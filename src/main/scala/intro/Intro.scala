package intro

class ResultSet {
  def close() { println("resultset closed") }
  def getResult = "resultti"
}

class Connection {
  def close() { println("conn closed") }
  def query(sql: String) = {
    println("querying " + sql)
    new ResultSet
  }
}

class Pool {
  def getConnection() = {
    println("opening connection")
    new Connection
  }
}

class JdbcTemplate(pool: Pool) {
  def first[T](handler: (String) => T): T = {
    val conn = pool.getConnection()
    val resultSet = conn.query("select 1")
    try {
      handler(resultSet.getResult)
    } finally {
      resultSet.close()
      conn.close()
    }
  }
}

object Foo {
  def main(args: Array[String]) {
    case class User(name: String, age: Int)
    val list = List(User("vermas", 53), User("ridge forrester", 130))
    println(list)
    val newList = list.map(x => x.copy(age = x.age + 10))
    println(newList)
  }
}