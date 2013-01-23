import Assignment1._

class Assignment1Spec extends Spec {
  val names = List("rane virtanen", "jore virtanen", "timo jutila")
  val namesWithAges = List("rane virtanen 19", "timo jutila", "ridge forrester 103")
  val somePersons = List(Person("rane", "virtanen"), Person("jore", "virtanen"))

  test("Assignment can filter by name") {
    assert(removeName(names, "jore") === List("rane virtanen", "timo jutila"))
  }

  test("Assignment turns data into Person objects") {
    val expected = List(Person("rane", "virtanen"), Person("jore", "virtanen"), Person("timo", "jutila"))
    assert(turnIntoPersons(names) === expected)
  }

  test("Assignment switches last and first names") {
    val expected = List(Person("virtanen", "rane"), Person("virtanen", "jore"))
    assert(switchFirstAndLastName(somePersons) === expected)
  }

  test("Assignment returns sum of all characters in all lastnames") {
    assert(countCharactersInLastNames(somePersons) === 16)
  }

  test("Assignment returns names list as a list of PersonWithAge objects") {
    val expected = List(
      PersonWithAge("rane", "virtanen", Some(19)),
      PersonWithAge("timo", "jutila", None),
      PersonWithAge("ridge", "forrester", Some(103)))
    assert(turnIntoPersonWithAges(namesWithAges) === expected)
  }

  // Uses also turnIntoPersonWithAges
  test("Assignment counts sum of all ages") {
    val personsWithAges = turnIntoPersonWithAges(namesWithAges)
    assert(sumOfAges(personsWithAges) === 122)
  }
}
