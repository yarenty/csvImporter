package com.yarenty.pix.process


import scala.slick.driver.MySQLDriver.simple._
import com.yarenty.pix.table.Tables
import scala.slick.jdbc.{GetResult, StaticQuery => Q}

object structure  extends App {

  val products = Tables.Product
  val categories = Tables.Category
  val markets = Tables.Market
  val segments = Tables.Segment
  val brands = Tables.Brand
  val brandCat = Tables.BrandCategory
  val brandMarket = Tables.BrandMarket
  val brandSegment = Tables.BrandSegment
  
  // Create a connection (called a "session") 
  Database.forURL("jdbc:mysql://localhost:3306/eshop", driver="com.mysql.jdbc.Driver", user="root", password="").withSession { implicit session =>
    
    Q.updateNA("delete from brand_segment where 1=1 ").execute
    Q.updateNA("delete from brand_market where 1=1 ").execute
    Q.updateNA("delete from brand_category where 1=1 ").execute
    Q.updateNA("delete from brand where 1=1 ").execute    
    Q.updateNA("delete from segment where 1=1 ").execute
    Q.updateNA("delete from market where 1=1 ").execute
    Q.updateNA("delete from category where 1=1 ").execute
    
    // categories
    products.groupBy(f => f.category).map{ 
      case (category,nos) => (category, nos.map(_.id).countDistinct)
    }.list.foreach( cat  =>  
      if (categories.filter( _.name === cat._1 ).exists == true) {
    	  categories.map(p => (p.name,p.nos))
    	  	.update((cat._1.get,cat._2))
      } else {
         categories.map(p => (p.name,p.nos))
         	.insert((cat._1.get,cat._2)) 
      }
    )
    println("categories")
    
    //markets
    products.groupBy(f => (f.category,f.market)).map{ 
      case ((category, market),nos) => ((category, market), nos.map(_.id).countDistinct)
    }.list.foreach( market  =>  
      if (markets.filter( _.name === market._1._2.get ).exists == true) {
    	  markets.map(p => (p.name,p.catId,p.nos))
    	  	.update((market._1._2.get, categories.filter(c => c.name === market._1._1).map(_.id).first , market._2))
      } else {
         markets.map(p => (p.name, p.catId, p.nos))
         	.insert((market._1._2.get,categories.filter(c => c.name === market._1._1).map(_.id).first, market._2)) 
      }
    )
    println("markets")
    
    //segment
    products.groupBy(f => (f.category,f.market,f.segment)).map{ 
      case ((category, market, segment),nos) => ((category, market, segment), nos.map(_.id).countDistinct)
    }.list.foreach( segment  =>  
      if (segments.filter( _.name === segment._1._2.get ).exists == true) {
    	  segments.map(p => (p.name,p.catId, p.marketId , p.nos))
    	  	.update((segment._1._3.get, 
    	  	    categories.filter(c => c.name === segment._1._1).map(_.id).first , 
    	  	    markets.filter(c => c.name === segment._1._2).map(_.id).first , 
    	  	    segment._2))
      } else {
         segments.map(p => (p.name, p.catId, p.marketId, p.nos))
         	.insert((segment._1._3.get,
         	    categories.filter(c => c.name === segment._1._1).map(_.id).first, 
         	    markets.filter(c => c.name === segment._1._2).map(_.id).first , 
         	segment._2)) 
      }
    )
    println("segments")
    
    // brands
    products.groupBy(f => f.brand).map{ 
      case (brand,nos) => (brand, nos.map(_.id).countDistinct)
    }.list.foreach( b  =>  
      if (brands.filter(_.name === b._1.get ).exists.run  ) {
    	  brands.map(p => (p.nos))
    	  	.update((b._2))
      } else {
         brands.map(p => (p.name,p.nos))
         	.insert((b._1.get,b._2)) 
      }
    )
    println("brands")
    
   
    
    //update ids
    products.map( f => (f.id, f.category,f.market,f.segment,f.brand) ).list.foreach( prod  => 
      products
      .filter(_.id === prod._1)
      .map(p => ( p.catId, p.marketId, p.segmentId, p.brandId))
      .update((
        categories.filter(c => c.name === prod._2.get).map(_.id).first ,
        markets.filter(c => c.name === prod._3.get).map(_.id).first ,
        segments.filter(c => c.name === prod._4.get).map(_.id).first ,
        brands.filter(c => c.name === prod._5.get).map(_.id).first 
        ))
      )
      println("updated product ids")

      
       //TODO: brand_category
    
    products.groupBy(f => (f.brandId,f.catId)).map{ 
      case ((brandId,categoryId),nos) => ((brandId, categoryId), nos.map(_.id).countDistinct)
    }.list.foreach( b  =>  
      if (brandCat.filter( u => u.brandId === b._1._1 && u.catId === b._1._2 ).exists.run  ) {
    	  brandCat.map(p => (p.nos))
    	  	.update((b._2))
      } else {
         brandCat.map(p => (p.brandId,p.catId,p.nos))
         	.insert((b._1._1,b._1._2,b._2)) 
      }
    )
    println("brands_category")

    //TODO: brand_market
    
    
   products.groupBy(f => (f.brandId,f.marketId)).map{ 
      case ((brandId,marketId),nos) => ((brandId, marketId), nos.map(_.id).countDistinct)
    }.list.foreach( b  =>  
      if (brandMarket.filter( u => u.brandId === b._1._1 && u.marketId === b._1._2 ).exists.run  ) {
    	  brandMarket.map(p => (p.nos))
    	  	.update((b._2))
      } else {
         brandMarket.map(p => (p.brandId,p.marketId,p.nos))
         	.insert((b._1._1,b._1._2,b._2)) 
      }
    )
    println("brands_market")
    
    //TODO: brand_segment
    products.groupBy(f => (f.brandId,f.segmentId)).map{ 
      case ((brandId,segmentId),nos) => ((brandId, segmentId), nos.map(_.id).countDistinct)
    }.list.foreach( b  =>  
      if (brandSegment.filter( u => u.brandId === b._1._1 && u.segmentId === b._1._2 ).exists.run  ) {
    	  brandSegment.map(p => (p.nos))
    	  	.update((b._2))
      } else {
         brandSegment.map(p => (p.brandId,p.segmentId,p.nos))
         	.insert((b._1._1,b._1._2,b._2)) 
      }
    )
    println("brands_segment")   
     
  }
}