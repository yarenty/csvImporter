package com.yarenty.pix.process


import scala.slick.driver.MySQLDriver.simple._
import com.yarenty.pix.table.Tables
import scala.slick.jdbc.{GetResult, StaticQuery => Q}
import scala.slick.jdbc.StaticQuery.interpolation
import scala.slick.jdbc.GetResult

object bestbuy extends App {

  val products = Tables.Product

  val bestbuy = Tables.BestBuy
  
  // Create a connection (called a "session") 
  Database.forURL("jdbc:mysql://localhost:3306/eshop", driver="com.mysql.jdbc.Driver", user="root", password="").withSession { implicit session =>


      
      Q.updateNA("delete from best_buy where 1=1 ").execute
      
      
    //update best buy
    products.filter( u => (u.price - u.pixPrice) > 0.1f )
    .map( f => (f.id, f.pixPrice, f.price) )
    .list.foreach(  prod  => 
      bestbuy.map( b => (b.prodId, b.percent) )
      insert((prod._1,
    		(((prod._3.get - prod._2.get) / prod._3.get) * 10000).toInt))
      )
      
      println("created best buy!!!")
      
  }
}