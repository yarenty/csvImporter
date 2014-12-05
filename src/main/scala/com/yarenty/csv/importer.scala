package com.yarenty.csv

import com.github.tototoshi.csv._
import java.sql.DriverManager
import java.sql.ResultSet
import scala.collection.mutable.MutableList

object importer {

  implicit object MyFormat extends DefaultCSVFormat {
    override val delimiter: Char = ';'
    //  val quoteChar: Char = '"'
    //  val lineTerminator: String = "\r\n"
  }

  val pixTypes = List(
    "PIXpro SKU",
    "Category", "Market", "Segment", "Brand", "Label",
    "Description", "PIXpro price", "Delivery", "Price", "Picture",
    "Availability", "Weight", "Weight-Volume", "Express Delivery",
    "EAN", "Manufacturer Reference", "WEEE", "Reprography",
    "Private Copying")

  val myTypes = List(
    "pix_id",
    "category", "market", "segment", "brand", "label",
    "descr", "pix_price", "delivery", "price", "picture",
    "availability", "weight", "weight_volume", "express_delivery",
    "ean", "manufacturer_ref", "wee", "reprography",
    "private_copy")

    
  def processFields(in: Map[String, String], conn: java.sql.Connection) {
    val l: MutableList[String] = new MutableList[String]()
    pixTypes.foreach(f =>
      l += (in.get(f).get).replace("\"", "\\\""))

    val sql = "INSERT INTO products (" + myTypes.mkString(",") +
      ") VALUES ( " + "\"" + l.mkString("\",\"") + "\")"
    //println(sql)

    val prep = conn.prepareStatement(sql)
    prep.executeUpdate

  }

  def main(args: Array[String]): Unit = {
    val reader = CSVReader
      .open("/Users/yarenty/Downloads/1350025975_test_v2_ie_en_full_hdr_20120921075331.csv")
      (MyFormat)

    val full = reader.allWithHeaders

    // create database connection
    val dbc = "jdbc:mysql://localhost:3306/cdcol?user=root&password="
    Class.forName("com.mysql.jdbc.Driver")
    val conn = DriverManager.getConnection(dbc)
    val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)

    // do database insert
    try {
      full.foreach(fields => processFields(fields, conn))
    } finally {
      conn.close
    }
    reader.close
  }

}