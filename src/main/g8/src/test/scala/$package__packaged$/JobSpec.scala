package $package$

import org.scalatest._

class JobSpec extends FlatSpec with Matchers with SparkSuite {

  "HelloTransform" should "add the correct greeting column to the dataframe" in withSparkDataFrame { (spark,df) =>
    val job = new Job(spark)
    job.helloTransform(df).first().getAs[String]("greeting") shouldEqual "Hello World!"
  }

}
