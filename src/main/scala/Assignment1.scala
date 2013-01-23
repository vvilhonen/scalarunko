case class Person(firstName: String, lastName: String)

case class PersonWithAge(firstName: String, lastName: String, age: Option[Int])

object Assignment1 {
  // 1.1 Removes given names that match pattern from all names and returns the result
  def removeName(names: List[String], name: String): List[String] = ???

  // 1.2 Returns list of Person objects made from names
  def turnIntoPersons(names: List[String]): List[Person] = ???

  // 1.3 Returns list of Person objects with first and last name switched
  def switchFirstAndLastName(names: List[Person]): List[Person] = ???

  // 1.4 Returns count of all characters in all lastnames
  def countCharactersInLastNames(names: List[Person]): Int = ???

  // 1.5 Returns names list as list of PersonWithAge objects
  def turnIntoPersonWithAges(names: List[String]): List[PersonWithAge] = ???

  // 1.6 Return sum of all ages
  def sumOfAges(names: List[PersonWithAge]): Int = ???
}
