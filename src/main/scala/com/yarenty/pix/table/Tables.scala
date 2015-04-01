package com.yarenty.pix.table
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = scala.slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  import scala.slick.model.ForeignKeyAction
  import scala.slick.collection.heterogenous._
  import scala.slick.collection.heterogenous.syntax._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{GetResult => GR}
  
  /** DDL for all tables. Call .create to execute. */
  lazy val ddl = BestBuy.ddl ++ Brand.ddl ++ BrandCategory.ddl ++ BrandMarket.ddl ++ BrandSegment.ddl ++ Category.ddl ++ CategoryRecom.ddl ++ Market.ddl ++ Product.ddl ++ Segment.ddl
  
  /** Entity class storing rows of table BestBuy
   *  @param prodId Database column prod_id DBType(INT)
   *  @param percent Database column percent DBType(INT) */
  case class BestBuyRow(prodId: Int, percent: Int)
  /** GetResult implicit for fetching BestBuyRow objects using plain SQL queries */
  implicit def GetResultBestBuyRow(implicit e0: GR[Int]): GR[BestBuyRow] = GR{
    prs => import prs._
    BestBuyRow.tupled((<<[Int], <<[Int]))
  }
  /** Table description of table best_buy. Objects of this class serve as prototypes for rows in queries. */
  class BestBuy(_tableTag: Tag) extends Table[BestBuyRow](_tableTag, "best_buy") {
    def * = (prodId, percent) <> (BestBuyRow.tupled, BestBuyRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (prodId.?, percent.?).shaped.<>({r=>import r._; _1.map(_=> BestBuyRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column prod_id DBType(INT) */
    val prodId: Column[Int] = column[Int]("prod_id")
    /** Database column percent DBType(INT) */
    val percent: Column[Int] = column[Int]("percent")
    
    /** Index over (percent) (database name percent) */
    val index1 = index("percent", percent)
    /** Uniqueness Index over (prodId) (database name prod_fp_idx) */
    val index2 = index("prod_fp_idx", prodId, unique=true)
  }
  /** Collection-like TableQuery object for table BestBuy */
  lazy val BestBuy = new TableQuery(tag => new BestBuy(tag))
  
  /** Entity class storing rows of table Brand
   *  @param id Database column id DBType(INT), AutoInc, PrimaryKey
   *  @param name Database column name DBType(VARCHAR), Length(200,true)
   *  @param nos Database column nos DBType(INT) */
  case class BrandRow(id: Int, name: String, nos: Int)
  /** GetResult implicit for fetching BrandRow objects using plain SQL queries */
  implicit def GetResultBrandRow(implicit e0: GR[Int], e1: GR[String]): GR[BrandRow] = GR{
    prs => import prs._
    BrandRow.tupled((<<[Int], <<[String], <<[Int]))
  }
  /** Table description of table brand. Objects of this class serve as prototypes for rows in queries. */
  class Brand(_tableTag: Tag) extends Table[BrandRow](_tableTag, "brand") {
    def * = (id, name, nos) <> (BrandRow.tupled, BrandRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, name.?, nos.?).shaped.<>({r=>import r._; _1.map(_=> BrandRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id DBType(INT), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name DBType(VARCHAR), Length(200,true) */
    val name: Column[String] = column[String]("name", O.Length(200,varying=true))
    /** Database column nos DBType(INT) */
    val nos: Column[Int] = column[Int]("nos")
    
    /** Uniqueness Index over (name) (database name name) */
    val index1 = index("name", name, unique=true)
  }
  /** Collection-like TableQuery object for table Brand */
  lazy val Brand = new TableQuery(tag => new Brand(tag))
  
  /** Entity class storing rows of table BrandCategory
   *  @param brandId Database column brand_id DBType(INT)
   *  @param catId Database column cat_id DBType(INT)
   *  @param nos Database column nos DBType(INT) */
  case class BrandCategoryRow(brandId: Int, catId: Int, nos: Int)
  /** GetResult implicit for fetching BrandCategoryRow objects using plain SQL queries */
  implicit def GetResultBrandCategoryRow(implicit e0: GR[Int]): GR[BrandCategoryRow] = GR{
    prs => import prs._
    BrandCategoryRow.tupled((<<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table brand_category. Objects of this class serve as prototypes for rows in queries. */
  class BrandCategory(_tableTag: Tag) extends Table[BrandCategoryRow](_tableTag, "brand_category") {
    def * = (brandId, catId, nos) <> (BrandCategoryRow.tupled, BrandCategoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (brandId.?, catId.?, nos.?).shaped.<>({r=>import r._; _1.map(_=> BrandCategoryRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column brand_id DBType(INT) */
    val brandId: Column[Int] = column[Int]("brand_id")
    /** Database column cat_id DBType(INT) */
    val catId: Column[Int] = column[Int]("cat_id")
    /** Database column nos DBType(INT) */
    val nos: Column[Int] = column[Int]("nos")
    
    /** Uniqueness Index over (brandId,catId) (database name brand_cat_idx) */
    val index1 = index("brand_cat_idx", (brandId, catId), unique=true)
  }
  /** Collection-like TableQuery object for table BrandCategory */
  lazy val BrandCategory = new TableQuery(tag => new BrandCategory(tag))
  
  /** Entity class storing rows of table BrandMarket
   *  @param brandId Database column brand_id DBType(INT)
   *  @param marketId Database column market_id DBType(INT)
   *  @param nos Database column nos DBType(INT) */
  case class BrandMarketRow(brandId: Int, marketId: Int, nos: Int)
  /** GetResult implicit for fetching BrandMarketRow objects using plain SQL queries */
  implicit def GetResultBrandMarketRow(implicit e0: GR[Int]): GR[BrandMarketRow] = GR{
    prs => import prs._
    BrandMarketRow.tupled((<<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table brand_market. Objects of this class serve as prototypes for rows in queries. */
  class BrandMarket(_tableTag: Tag) extends Table[BrandMarketRow](_tableTag, "brand_market") {
    def * = (brandId, marketId, nos) <> (BrandMarketRow.tupled, BrandMarketRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (brandId.?, marketId.?, nos.?).shaped.<>({r=>import r._; _1.map(_=> BrandMarketRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column brand_id DBType(INT) */
    val brandId: Column[Int] = column[Int]("brand_id")
    /** Database column market_id DBType(INT) */
    val marketId: Column[Int] = column[Int]("market_id")
    /** Database column nos DBType(INT) */
    val nos: Column[Int] = column[Int]("nos")
    
    /** Uniqueness Index over (brandId,marketId) (database name brand_market_idx) */
    val index1 = index("brand_market_idx", (brandId, marketId), unique=true)
  }
  /** Collection-like TableQuery object for table BrandMarket */
  lazy val BrandMarket = new TableQuery(tag => new BrandMarket(tag))
  
  /** Entity class storing rows of table BrandSegment
   *  @param brandId Database column brand_id DBType(INT)
   *  @param segmentId Database column segment_id DBType(INT)
   *  @param nos Database column nos DBType(INT) */
  case class BrandSegmentRow(brandId: Int, segmentId: Int, nos: Int)
  /** GetResult implicit for fetching BrandSegmentRow objects using plain SQL queries */
  implicit def GetResultBrandSegmentRow(implicit e0: GR[Int]): GR[BrandSegmentRow] = GR{
    prs => import prs._
    BrandSegmentRow.tupled((<<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table brand_segment. Objects of this class serve as prototypes for rows in queries. */
  class BrandSegment(_tableTag: Tag) extends Table[BrandSegmentRow](_tableTag, "brand_segment") {
    def * = (brandId, segmentId, nos) <> (BrandSegmentRow.tupled, BrandSegmentRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (brandId.?, segmentId.?, nos.?).shaped.<>({r=>import r._; _1.map(_=> BrandSegmentRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column brand_id DBType(INT) */
    val brandId: Column[Int] = column[Int]("brand_id")
    /** Database column segment_id DBType(INT) */
    val segmentId: Column[Int] = column[Int]("segment_id")
    /** Database column nos DBType(INT) */
    val nos: Column[Int] = column[Int]("nos")
    
    /** Uniqueness Index over (brandId,segmentId) (database name brand_seg_idx) */
    val index1 = index("brand_seg_idx", (brandId, segmentId), unique=true)
  }
  /** Collection-like TableQuery object for table BrandSegment */
  lazy val BrandSegment = new TableQuery(tag => new BrandSegment(tag))
  
  /** Entity class storing rows of table Category
   *  @param id Database column id DBType(INT), AutoInc, PrimaryKey
   *  @param name Database column name DBType(VARCHAR), Length(254,true)
   *  @param nos Database column nos DBType(INT) */
  case class CategoryRow(id: Int, name: String, nos: Int)
  /** GetResult implicit for fetching CategoryRow objects using plain SQL queries */
  implicit def GetResultCategoryRow(implicit e0: GR[Int], e1: GR[String]): GR[CategoryRow] = GR{
    prs => import prs._
    CategoryRow.tupled((<<[Int], <<[String], <<[Int]))
  }
  /** Table description of table category. Objects of this class serve as prototypes for rows in queries. */
  class Category(_tableTag: Tag) extends Table[CategoryRow](_tableTag, "category") {
    def * = (id, name, nos) <> (CategoryRow.tupled, CategoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, name.?, nos.?).shaped.<>({r=>import r._; _1.map(_=> CategoryRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id DBType(INT), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name DBType(VARCHAR), Length(254,true) */
    val name: Column[String] = column[String]("name", O.Length(254,varying=true))
    /** Database column nos DBType(INT) */
    val nos: Column[Int] = column[Int]("nos")
  }
  /** Collection-like TableQuery object for table Category */
  lazy val Category = new TableQuery(tag => new Category(tag))
  
  /** Entity class storing rows of table CategoryRecom
   *  @param categoryId Database column category_id DBType(INT)
   *  @param productId Database column product_id DBType(INT) */
  case class CategoryRecomRow(categoryId: Int, productId: Int)
  /** GetResult implicit for fetching CategoryRecomRow objects using plain SQL queries */
  implicit def GetResultCategoryRecomRow(implicit e0: GR[Int]): GR[CategoryRecomRow] = GR{
    prs => import prs._
    CategoryRecomRow.tupled((<<[Int], <<[Int]))
  }
  /** Table description of table category_recom. Objects of this class serve as prototypes for rows in queries. */
  class CategoryRecom(_tableTag: Tag) extends Table[CategoryRecomRow](_tableTag, "category_recom") {
    def * = (categoryId, productId) <> (CategoryRecomRow.tupled, CategoryRecomRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (categoryId.?, productId.?).shaped.<>({r=>import r._; _1.map(_=> CategoryRecomRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column category_id DBType(INT) */
    val categoryId: Column[Int] = column[Int]("category_id")
    /** Database column product_id DBType(INT) */
    val productId: Column[Int] = column[Int]("product_id")
    
    /** Uniqueness Index over (categoryId,productId) (database name cat_prod_rec_idx) */
    val index1 = index("cat_prod_rec_idx", (categoryId, productId), unique=true)
  }
  /** Collection-like TableQuery object for table CategoryRecom */
  lazy val CategoryRecom = new TableQuery(tag => new CategoryRecom(tag))
  
  /** Entity class storing rows of table Market
   *  @param id Database column id DBType(INT), AutoInc, PrimaryKey
   *  @param catId Database column cat_id DBType(INT)
   *  @param name Database column name DBType(VARCHAR), Length(254,true)
   *  @param nos Database column nos DBType(INT) */
  case class MarketRow(id: Int, catId: Int, name: String, nos: Int)
  /** GetResult implicit for fetching MarketRow objects using plain SQL queries */
  implicit def GetResultMarketRow(implicit e0: GR[Int], e1: GR[String]): GR[MarketRow] = GR{
    prs => import prs._
    MarketRow.tupled((<<[Int], <<[Int], <<[String], <<[Int]))
  }
  /** Table description of table market. Objects of this class serve as prototypes for rows in queries. */
  class Market(_tableTag: Tag) extends Table[MarketRow](_tableTag, "market") {
    def * = (id, catId, name, nos) <> (MarketRow.tupled, MarketRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, catId.?, name.?, nos.?).shaped.<>({r=>import r._; _1.map(_=> MarketRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id DBType(INT), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column cat_id DBType(INT) */
    val catId: Column[Int] = column[Int]("cat_id")
    /** Database column name DBType(VARCHAR), Length(254,true) */
    val name: Column[String] = column[String]("name", O.Length(254,varying=true))
    /** Database column nos DBType(INT) */
    val nos: Column[Int] = column[Int]("nos")
  }
  /** Collection-like TableQuery object for table Market */
  lazy val Market = new TableQuery(tag => new Market(tag))
  
  /** Row type of table Product */
  type ProductRow = HCons[Int,HCons[String,HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Int,HCons[Int,HCons[Int,HCons[Int,HCons[Option[String],HCons[Option[String],HCons[Option[Float],HCons[Option[Float],HCons[Option[Float],HCons[Option[String],HCons[Option[String],HCons[Option[Float],HCons[Option[Float],HCons[Option[Float],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Boolean],HCons[Option[Float],HCons[Option[Float],HCons[Option[Float],HCons[Option[Float],HCons[Option[Float],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for ProductRow providing default values if available in the database schema. */
  def ProductRow(id: Int, pixId: String, category: Option[String] = None, market: Option[String] = None, segment: Option[String] = None, brand: Option[String] = None, catId: Int, marketId: Int, segmentId: Int, brandId: Int, label: Option[String] = None, descr: Option[String] = None, pixPrice: Option[Float] = None, delivery: Option[Float] = None, price: Option[Float] = None, picture: Option[String] = None, availability: Option[String] = None, weight: Option[Float] = None, weightVolume: Option[Float] = None, expressDelivery: Option[Float] = None, ean: Option[String] = None, manufacturerRef: Option[String] = None, wee: Option[String] = None, reprography: Option[String] = None, privateCopy: Option[String] = None, isNew: Option[Boolean] = None, myprice: Option[Float] = None, myvat: Option[Float] = None, myfullprice: Option[Float] = None, mydelivery: Option[Float] = None, myexpress: Option[Float] = None): ProductRow = {
    id :: pixId :: category :: market :: segment :: brand :: catId :: marketId :: segmentId :: brandId :: label :: descr :: pixPrice :: delivery :: price :: picture :: availability :: weight :: weightVolume :: expressDelivery :: ean :: manufacturerRef :: wee :: reprography :: privateCopy :: isNew :: myprice :: myvat :: myfullprice :: mydelivery :: myexpress :: HNil
  }
  /** GetResult implicit for fetching ProductRow objects using plain SQL queries */
  implicit def GetResultProductRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]], e3: GR[Option[Float]], e4: GR[Option[Boolean]]): GR[ProductRow] = GR{
    prs => import prs._
    <<[Int] :: <<[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<[Int] :: <<[Int] :: <<[Int] :: <<[Int] :: <<?[String] :: <<?[String] :: <<?[Float] :: <<?[Float] :: <<?[Float] :: <<?[String] :: <<?[String] :: <<?[Float] :: <<?[Float] :: <<?[Float] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Boolean] :: <<?[Float] :: <<?[Float] :: <<?[Float] :: <<?[Float] :: <<?[Float] :: HNil
  }
  /** Table description of table product. Objects of this class serve as prototypes for rows in queries. */
  class Product(_tableTag: Tag) extends Table[ProductRow](_tableTag, "product") {
    def * = id :: pixId :: category :: market :: segment :: brand :: catId :: marketId :: segmentId :: brandId :: label :: descr :: pixPrice :: delivery :: price :: picture :: availability :: weight :: weightVolume :: expressDelivery :: ean :: manufacturerRef :: wee :: reprography :: privateCopy :: isNew :: myprice :: myvat :: myfullprice :: mydelivery :: myexpress :: HNil
    
    /** Database column id DBType(INT), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column pix_id DBType(VARCHAR), Length(20,true) */
    val pixId: Column[String] = column[String]("pix_id", O.Length(20,varying=true))
    /** Database column category DBType(VARCHAR), Length(100,true), Default(None) */
    val category: Column[Option[String]] = column[Option[String]]("category", O.Length(100,varying=true), O.Default(None))
    /** Database column market DBType(VARCHAR), Length(100,true), Default(None) */
    val market: Column[Option[String]] = column[Option[String]]("market", O.Length(100,varying=true), O.Default(None))
    /** Database column segment DBType(VARCHAR), Length(100,true), Default(None) */
    val segment: Column[Option[String]] = column[Option[String]]("segment", O.Length(100,varying=true), O.Default(None))
    /** Database column brand DBType(VARCHAR), Length(200,true), Default(None) */
    val brand: Column[Option[String]] = column[Option[String]]("brand", O.Length(200,varying=true), O.Default(None))
    /** Database column cat_id DBType(INT) */
    val catId: Column[Int] = column[Int]("cat_id")
    /** Database column market_id DBType(INT) */
    val marketId: Column[Int] = column[Int]("market_id")
    /** Database column segment_id DBType(INT) */
    val segmentId: Column[Int] = column[Int]("segment_id")
    /** Database column brand_id DBType(INT) */
    val brandId: Column[Int] = column[Int]("brand_id")
    /** Database column label DBType(VARCHAR), Length(200,true), Default(None) */
    val label: Column[Option[String]] = column[Option[String]]("label", O.Length(200,varying=true), O.Default(None))
    /** Database column descr DBType(TEXT), Length(65535,true), Default(None) */
    val descr: Column[Option[String]] = column[Option[String]]("descr", O.Length(65535,varying=true), O.Default(None))
    /** Database column pix_price DBType(FLOAT), Default(None) */
    val pixPrice: Column[Option[Float]] = column[Option[Float]]("pix_price", O.Default(None))
    /** Database column delivery DBType(FLOAT), Default(None) */
    val delivery: Column[Option[Float]] = column[Option[Float]]("delivery", O.Default(None))
    /** Database column price DBType(FLOAT), Default(None) */
    val price: Column[Option[Float]] = column[Option[Float]]("price", O.Default(None))
    /** Database column picture DBType(VARCHAR), Length(250,true), Default(None) */
    val picture: Column[Option[String]] = column[Option[String]]("picture", O.Length(250,varying=true), O.Default(None))
    /** Database column availability DBType(VARCHAR), Length(40,true), Default(None) */
    val availability: Column[Option[String]] = column[Option[String]]("availability", O.Length(40,varying=true), O.Default(None))
    /** Database column weight DBType(FLOAT), Default(None) */
    val weight: Column[Option[Float]] = column[Option[Float]]("weight", O.Default(None))
    /** Database column weight_volume DBType(FLOAT), Default(None) */
    val weightVolume: Column[Option[Float]] = column[Option[Float]]("weight_volume", O.Default(None))
    /** Database column express_delivery DBType(FLOAT), Default(None) */
    val expressDelivery: Column[Option[Float]] = column[Option[Float]]("express_delivery", O.Default(None))
    /** Database column ean DBType(VARCHAR), Length(100,true), Default(None) */
    val ean: Column[Option[String]] = column[Option[String]]("ean", O.Length(100,varying=true), O.Default(None))
    /** Database column manufacturer_ref DBType(VARCHAR), Length(100,true), Default(None) */
    val manufacturerRef: Column[Option[String]] = column[Option[String]]("manufacturer_ref", O.Length(100,varying=true), O.Default(None))
    /** Database column wee DBType(VARCHAR), Length(100,true), Default(None) */
    val wee: Column[Option[String]] = column[Option[String]]("wee", O.Length(100,varying=true), O.Default(None))
    /** Database column reprography DBType(VARCHAR), Length(100,true), Default(None) */
    val reprography: Column[Option[String]] = column[Option[String]]("reprography", O.Length(100,varying=true), O.Default(None))
    /** Database column private_copy DBType(VARCHAR), Length(100,true), Default(None) */
    val privateCopy: Column[Option[String]] = column[Option[String]]("private_copy", O.Length(100,varying=true), O.Default(None))
    /** Database column is_new DBType(BIT), Default(None) */
    val isNew: Column[Option[Boolean]] = column[Option[Boolean]]("is_new", O.Default(None))
    /** Database column myPrice DBType(FLOAT), Default(None) */
    val myprice: Column[Option[Float]] = column[Option[Float]]("myPrice", O.Default(None))
    /** Database column myVAT DBType(FLOAT), Default(None) */
    val myvat: Column[Option[Float]] = column[Option[Float]]("myVAT", O.Default(None))
    /** Database column myFullPrice DBType(FLOAT), Default(None) */
    val myfullprice: Column[Option[Float]] = column[Option[Float]]("myFullPrice", O.Default(None))
    /** Database column myDelivery DBType(FLOAT), Default(None) */
    val mydelivery: Column[Option[Float]] = column[Option[Float]]("myDelivery", O.Default(None))
    /** Database column myExpress DBType(FLOAT), Default(None) */
    val myexpress: Column[Option[Float]] = column[Option[Float]]("myExpress", O.Default(None))
    
    /** Index over (pixId) (database name pix_id) */
    val index1 = index("pix_id", pixId :: HNil)
    /** Uniqueness Index over (pixId) (database name pix_id_2) */
    val index2 = index("pix_id_2", pixId :: HNil, unique=true)
  }
  /** Collection-like TableQuery object for table Product */
  lazy val Product = new TableQuery(tag => new Product(tag))
  
  /** Entity class storing rows of table Segment
   *  @param id Database column id DBType(INT), AutoInc, PrimaryKey
   *  @param catId Database column cat_id DBType(INT)
   *  @param marketId Database column market_id DBType(INT)
   *  @param name Database column name DBType(VARCHAR), Length(254,true)
   *  @param nos Database column nos DBType(INT) */
  case class SegmentRow(id: Int, catId: Int, marketId: Int, name: String, nos: Int)
  /** GetResult implicit for fetching SegmentRow objects using plain SQL queries */
  implicit def GetResultSegmentRow(implicit e0: GR[Int], e1: GR[String]): GR[SegmentRow] = GR{
    prs => import prs._
    SegmentRow.tupled((<<[Int], <<[Int], <<[Int], <<[String], <<[Int]))
  }
  /** Table description of table segment. Objects of this class serve as prototypes for rows in queries. */
  class Segment(_tableTag: Tag) extends Table[SegmentRow](_tableTag, "segment") {
    def * = (id, catId, marketId, name, nos) <> (SegmentRow.tupled, SegmentRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, catId.?, marketId.?, name.?, nos.?).shaped.<>({r=>import r._; _1.map(_=> SegmentRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id DBType(INT), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column cat_id DBType(INT) */
    val catId: Column[Int] = column[Int]("cat_id")
    /** Database column market_id DBType(INT) */
    val marketId: Column[Int] = column[Int]("market_id")
    /** Database column name DBType(VARCHAR), Length(254,true) */
    val name: Column[String] = column[String]("name", O.Length(254,varying=true))
    /** Database column nos DBType(INT) */
    val nos: Column[Int] = column[Int]("nos")
  }
  /** Collection-like TableQuery object for table Segment */
  lazy val Segment = new TableQuery(tag => new Segment(tag))
}