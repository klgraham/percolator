# Introduction

Percolation models are used to study the physics of disordered systems and critical phenomena. Percolation is one of the simplest probabilistic models that exhibits "critical phenomena", which is abrupt changes in a system's properties are triggered by changes in the value of an adjustable parameter.

Here are a few nice intros to percolation theory:

* http://wwwf.imperial.ac.uk/~mgastner/percolation/percolation.html
* http://www.mit.edu/~levitov/8.334/notes/percol_notes.pdf (textbook)

# Usage:

The object Percolator takes two inputs: the lattice size (N x N lattice) and fraction of lattice sites which are open. Usage instructions follow.

1. ```$ sbt```
* ```> run <lattice-size> <% open lattice sites>```
