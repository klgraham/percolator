package percolation

import util.Random
/**
 * Created by IntelliJ IDEA.
 * User: kgraham
 * Date: 12/16/11
 * Time: 2:11 PM
 * To change this template use File | Settings | File Templates.
 */

class PercolationLattice(latticeSize: Int)
{
  var openSites = Array.ofDim[Boolean](latticeSize, latticeSize)
  var fullSites = Array.ofDim[Boolean](latticeSize, latticeSize)
  val size = latticeSize
  
//  def printOpenSites{
//    println("\n")
//    for (i <- 0 until latticeSize){
//      openSites(i).foreach(b => (if (b) Console.print("1\t") else Console.print("0\t")))
//      println()
//    }
//  }
  
  def printPercolationLattice{
    var fractionFilled = 0
    println("\n")
    for (x <- 0 until latticeSize){
      for (y <- 0 until latticeSize){
        if (fullSites(x)(y)){
          print("1 ")
          fractionFilled += 1
        } // full site
        else if (openSites(x)(y) && !fullSites(x)(y)) print("0 ")  // open but empty
        else
          print("* ")  // blocked
      }
      println()
    }
    println("\nFilled fraction: " + fractionFilled)
  }
}

object PercolationLattice{
  def buildRandomLattice(probability: Double, size: Int) : PercolationLattice = {
    val r: Random = new Random
    val lattice = new PercolationLattice(size)
    for (i <- 0 until size){
      for (j <- 0 until size){
        lattice.openSites(i)(j) = (r.nextDouble() < probability)
      }
    }
    lattice
  }
}