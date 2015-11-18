package percolation

/**
 * Created by IntelliJ IDEA.
 * User: kgraham
 * Date: 12/16/11
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */

object Percolator{

  // given an N-by-N matrix of open sites, return an N-by-N matrix
  // of sites reachable from the top
  def flow(lattice: PercolationLattice): Array[Array[Boolean]] = {
    val N = lattice.size
    for (i <- 0 until N){
      flow(lattice, 0, i)
    }
    lattice.fullSites
  }  

  // determine set of full sites using depth first search
  def flow(lattice: PercolationLattice, row: Int, col: Int): Unit = {
    val N = lattice.size
    
    if (row < 0 || row >= N) return // invalid row index
    if (col < 0 || col >= N) return // invalid column index
    if (!lattice.openSites(row)(col)) return // site not open
    if (lattice.fullSites(row)(col)) return // site already full

    // fill row,col
    lattice.fullSites(row)(col) = true

    flow(lattice, row+1, col);   // down
    flow(lattice, row, col+1);   // right
    flow(lattice, row, col-1);   // left
    flow(lattice, row-1, col);   // up
  }

  // does the system percolate
  def percolates(lattice: PercolationLattice) : Boolean = {
    val latticeSize = lattice.size
    lattice.fullSites = flow(lattice)
    lattice.fullSites(latticeSize - 1).foreach(b => if (b) return true)
    false
  }

  // build random lattice
  def randomLattice(size: Int, prob: Double): PercolationLattice = {
    PercolationLattice.buildRandomLattice(prob, size)
  }

  // test it
  def main(args: Array[String]){
    var percolationThresholdEstimate: Double = 0
    val NIter = 10000
    for (iter <- 0 until NIter){
      val lattice: PercolationLattice = randomLattice(args(0).toInt, args(1).toDouble)
      lattice.fullSites = flow(lattice)
      if (percolates(lattice)){
//        lattice.printPercolationLattice
        percolationThresholdEstimate += 1
//        return
      }
    }

    println("Percolation Threshold Estimate: " + percolationThresholdEstimate / NIter.toDouble)
  }
}