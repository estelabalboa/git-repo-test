package com.test.spark

import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{FlatSpec, Matchers}


class WordCountTest extends FlatSpec with Matchers {

  val conf = new SparkConf().setAppName("WordCount")
  val sc = new SparkContext(conf)


  "method main" should "writte in hdfs the results" in {

    val inputTest = sc.textFile("SparkExample/src/test/resources/input.txt")

    //result should be("src")
  }

}
