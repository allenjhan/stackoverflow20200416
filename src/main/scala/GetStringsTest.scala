object GetStringsTest extends App{

  def getStringsOriginal(lst: Traversable[String]): Traversable[String] = {
    val someStrings = lst.filter(_.length >= 6)
    val stringCount = someStrings.foldLeft(0)((accum, line) => accum + 1)
    println(stringCount)
    someStrings
  }

  def getStringsOnePass(lst: Traversable[String]): Traversable[String] = {
    val folded = lst.foldRight((IndexedSeq[String](), 0)){ (e, acc) =>
      if (e.length >= 6) (e +: acc._1, acc._2 + 1)
      else acc
    }
    println(folded._2)
    folded._1
  }

  val myList = List("hi", "defenestration", "supercilious", "football", "tea")
  println(getStringsOriginal(myList))
  println(getStringsOnePass(myList))
}
