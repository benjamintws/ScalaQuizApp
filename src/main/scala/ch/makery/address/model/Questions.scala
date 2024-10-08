package ch.makery.address.model

case class Question(questionText: String, options: List[String], correctAnswer: Int)

class Questions {
  private val questionSets: Map[String, List[Question]] = Map(
    "Premier League (23/24 season)" -> List(
      Question("Who won the Golden Boot for the 23/24 season?", List("Alexander Isak", "Cole Palmer", "Erling Haaland", "Ollie Watkins"), 2),
      Question("Which of these teams didn't get relegated?", List("Everton", "Luton Town", "Burnley", "Sheffield United"), 0),
      Question("Which team won the FA Cup for the 23/24 season?", List("Coventry City", "Chelsea", "Manchester City", "Manchester United"), 3),
      Question("Who had the most G/A contributions for the 23/24 season?", List("Erling Haaland", "Cole Palmer", "Ollie Watkins", "Mohamed Salah"), 1),
      Question("Which of these teams received a points deduction for violating FFP rules?", List("Manchester City", "Everton", "Brentford", "Fulham"), 1),
      Question("Who registered the most assists for the 23/24 season?", List("Cole Palmer", "Martin Odegaard", "Pascal Gross", "Ollie Watkins"), 3),
      Question("Who kept the most clean sheets for the 23/24 season?", List("Ederson Moraes", "Jordan Pickford", "David Raya", "Bernd Leno"), 2),
      Question("Who registered the most yellow cards for the 23/24 season?", List("Joao Palhinha", "Douglas Luiz", "Edson Alvarez", "James Tarkowski"), 0),
      Question("Which team had the most GF for the 23/24 season?", List("Liverpool", "Manchester City", "Arsenal", "Aston Villa"), 1),
      Question("Which team had the most GA for the 23/24 season?", List("Luton Town", "Everton", "Sheffield United", "Burnley"), 2)
    ),

    "Premier League History" -> List(
      Question("What year was the Premier League established?", List("1990", "1991", "1992", "1993"), 2),
      Question("Which team was the last winners of the First Division, before the founding of the Premier League?", List("Leeds United", "Manchester United", "Arsenal", "Liverpool"), 0),
      Question("Who is the all-time goalscorer in the Premier League?", List("Harry Kane", "Alan Shearer", "Wayne Rooney", "Sergio Aguero"), 1),
      Question("Who is the all-time assist leader in the Premier League?", List("Kevin De Bruyne", "Frank Lampard", "Cesc Fabregas", "Ryan Giggs"), 3),
      Question("Who has kept the most clean sheets in the Premier League?", List("David James", "Petr Cech", "David Seaman", "David de Gea"), 1),
      Question("Who has made the most Premier League appearances?", List("James Milner", "Ryan Giggs", "Gareth Barry", "Frank Lampard"), 2),
      Question("Which team has won the most Premier League titles?", List("Chelsea", "Manchester City", "Arsenal", "Manchester United"), 3),
      Question("Who has tallied the most red cards in the Premier League?", List("Vinnie Jones", "Roy Keane", "Joey Barton", "Patrick Vieira"), 3),
      Question("Who has registered the most own goals in the Premier League?", List("Richard Dunne", "Jamie Carragher", "Phil Jagielka", "Lewis Dunk"), 0),
      Question("Which of these players were not involved in Arsenal's historic 03/04 season?", List("Jens Lehmann", "Cesc Fabregas", "Dennis Bergkamp", "Robin van Persie"), 3),
      Question("Which of these teams registered the most points in a single Premier League season?", List("Manchester City", "Manchester United", "Liverpool", "Arsenal"), 0),
      Question("Which of these teams have never won the Premier League?", List("Blackburn Rovers", "Liverpool", "Leeds United", "Leicsester City"), 2),
      Question("Which of these teams were once relegated from the Premier League?", List("Everton", "Manchester City", "Liverpool", "Tottenham Hotspurs"), 1),
      Question("Which goalkeepers have saved the most penalties in the Premier League?", List("Lukasz Fabianski", "Ben Foster", "Joe Hart", "Heurelho Gomes"), 0),
      Question("Who has registered the most yellow cards in the Premier League?", List("Wayne Rooney", "Gareth Barry", "Lee Bowyer", "Kevin Davies"), 1)
    ),

    "World Cup History" -> List(
      Question("Which country won the 2018 FIFA World Cup?", List("Brazil", "France", "Germany", "Argentina"), 1),
      Question("Which country won the first edition of the FIFA World Cup?", List("West Germany", "Brazil", "Italy", "Uruguay"), 3),
      Question("When was the next FIFA World Cup played after the 1938 edition?", List("1942", "1952", "1946", "1950"), 1),
      Question("Which country has won the most FIFA World Cups?", List("Argentina", "Brazil", "France", "Germany"), 1),
      Question("How many FIFA World Cups have Italy won?", List("1", "2", "3", "4"), 3),
      Question("Which of these countries have never won a FIFA World Cup?", List("Uruguay", "England", "Netherlands", "Spain"), 2),
      Question("Who is the all-time goalscorer in the FIFA World Cup?", List("Miroslav Klose", "Ronaldo Nazario", "Gerd Muller", "Pele"), 0),
      Question("Which country has suffered the biggest defeat in the FIFA World Cup?", List("Cuba", "South Korea", "El Salvador", "Bolivia"), 2),
      Question("Who is the all-time clean sheet leader in the FIFA World Cup?", List("Peter Shilton", "Lev Yashin", "Gianluigi Buffon", "Oliver Kahn"), 0),
      Question("Which of these legends have won a FIFA World Cup", List("Johan Cryuff", "Paolo Maldini", "Zinedine Zidane", "Eusebio"), 2)
    )
    // Additional categories for questions will be added here if necessary
  )

  // Method to retrieve questions by category
  def getQuestionsByCategory(category: String): Option[List[Question]] = {
    questionSets.get(category)
  }
}

object Questions {
  def apply(): Questions = new Questions()
}

