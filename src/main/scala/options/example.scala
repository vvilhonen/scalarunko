class OldSchool(firstName: String, lastName: String, age: Int) {
  override def toString: String = {
    var firstNameStr = ""
    if (firstName != null) {
      firstNameStr = firstName
    } else {
      return "missing required values"
    }

    var lastNameStr = ""
    if (lastName != null) {
      lastNameStr = lastName
    } else {
      return "missing required values"
    }

    var ageStr = ""
    if (age != null) {
      ageStr = age + " years old"
    } else {
      ageStr = "with age omitted"
    }

    firstNameStr + " " + lastNameStr + " " + ageStr
  }
}

class Leet(firstName: Option[String], lastName: Option[String], age: Option[Int]) {
  override def toString: String = {
    val ageDescriptiongFunc = (x: Int) => x + " years old"

    val result = for {
      firstNameStr <- firstName
      lastNameStr <- lastName
      ageStr = age.map(ageDescriptiongFunc).getOrElse("with age omitted")
    } yield firstNameStr + " " + lastNameStr + " " + ageStr

    result.getOrElse("missing required values")
  }
}