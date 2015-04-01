package com.yarenty.pix.process


import scala.slick.driver.MySQLDriver.simple._
import com.yarenty.pix.table.Tables
import scala.slick.jdbc.{GetResult, StaticQuery => Q}

object updateProds  extends App {

  val tempProducts = Tables.Product
  val products = Tables.Product


  
  // Create a connection (called a "session") 
  Database.forURL("jdbc:mysql://localhost:3306/eshop", driver="com.mysql.jdbc.Driver", user="root", password="").withSession { implicit session =>

 /*   
    //update ids
    products
    .filter( u => (u.pixPrice < 20.0f))
    .map( f => (f.id, f.category,f.market,f.segment,f.brand) ).list.foreach( prod  => 
      {
      products
      .map(z => ( 
    z.category, z.market, z.segment, z.brand, z.label,
    z.descr, z.pixPrice, z.delivery, z.price, z.picture,
    z.availability, z.weight, z.weightVolume, z.expressDelivery,
    z.ean, z.manufacturerRef, z.wee, z.reprography,
     z.privateCopy)
    )
      .update( (
          
   z.category, z.market, z.segment, z.brand, z.label,
    z.descr, z.pixPrice, z.delivery, z.price, z.picture,
    z.availability, z.weight, z.weightVolume, z.expressDelivery,
    z.ean, z.manufacturerRef, z.wee, z.reprography,
     z.privateCopy
        
        ) )
      }
        
      )
 */     
      
      println("products updated")

     
  }
}