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
    val jdbc = new JdbcTemplate(new Pool)
    val intArvo = jdbc.first[Int]((x) => x)
    //
    // List<String> lista = new ArrayList<String>()
    //val lista: List[String] = List[String]("a")

    //jdbc.first(println(_))
    //jdbc.first((result) => println(result))
    //jdbc.first{(result) => println(result)}
  }
}