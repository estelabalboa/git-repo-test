package com.test.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions

object WordCount {
 def main(args: Array[String]) = {

 // val enviroment = args(0)
  //Start the Spark context
  val conf = new SparkConf().setAppName("WordCount").setMaster("local")
  val sc = new SparkContext(conf)

 //Read input file

 val input = sc.textFile("SparkExample/src/main/resources/input.txt")

 val output = input.flatMap { line => line.split(" ")
 } //for each line split the line into words.
 .map { word => (word, 1) 
 } //for each word create a key/value pair, with the word as key and 1 as value
 
 .reduceByKey(_ + _) //Sum values with same key
 .saveAsTextFile("SparkExample/src/test/resources/outputfile") //Save result to a text file
 //.saveAsTextFile("hdfs://localhost:8020/pruebas/wordcount")

 //StoppingSpark context
 sc.stop()
 }
}