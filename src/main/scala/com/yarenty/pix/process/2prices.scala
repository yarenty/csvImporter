package com.yarenty.pix.process


import scala.slick.driver.MySQLDriver.simple._
import com.yarenty.pix.table.Tables
import scala.slick.jdbc.{GetResult, StaticQuery => Q}

object prices  extends App {

  val products = Tables.Product
  
  // Create a connection (called a "session") 
  Database.forURL("jdbc:mysql://localhost:3306/eshop", driver="com.mysql.jdbc.Driver", user="root", password="").withSession { implicit session =>

      
       
     //update prices
    products.map( f => (f.id, f.price, f.delivery, f.expressDelivery) ).list.foreach( prod  => 
      products
      .filter(_.id === prod._1)
      .map(p => ( p.myprice, p.myvat, p.myfullprice, p.mydelivery, p.myexpress))
      .update( {
         val price = ("%3.2f" format  ( prod._2.get * 1.1 + 1.0)).toFloat
         val vat = ("%3.2f" format ( price * 0.23)).toFloat
         val full = price+vat
         ( Option(price) ,
           Option(vat),
           Option(full),
           prod._3,
           prod._4
         )
      	}  
    	 )
      )
      println("updated prices") 
      
      

  }
}