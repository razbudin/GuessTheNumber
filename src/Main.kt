// Уровень сложности, колличество попыток, диапазон чисел
enum class Complexity (val title: String, val attempt: Int, val range: IntRange) {
    LIGHT("Легко", 6, 0..100),
    MEDIUM("Средне", 5, -100..100),
    HIGHT("Сложно", 4, -200..200);
}

// Хотите поиграть еще?
var cntGame: Int = 1
fun haveNewGame(n: Int) {
    cntGame = if (n == 0) 0 else 1
}

fun main() {

    while(cntGame != 0) {

        val complexitys = Complexity.entries
        var complexityIndex: Int

        // Выбор сложности игры
        do {
            var cnt: Int = 0
            println("Выберите сложность игры ")
            print("0 - ${complexitys[0].title}, 1 - ${complexitys[1].title}, 2 - ${complexitys[2].title}: ")
            complexityIndex = readln().toInt()
            //
            if (complexityIndex in 0..2) {
                println("Вы выбрали сложность ${complexitys[complexityIndex].title}")
                cnt = 0
            } else {
                println("Вы ввели не число или число выходящее за рамки доступных")
                println("Введите заново")
                cnt++
            }
        } while (cnt > 0)

        // Установка переменных в зависимости от выбранной сложности
        val complexity: Complexity = complexitys[complexityIndex]
        var attempt: Int
        var rangeNum: IntRange
        when (complexity) {
            Complexity.LIGHT -> {
                attempt = Complexity.LIGHT.attempt
                rangeNum = Complexity.LIGHT.range
            }
            Complexity.MEDIUM -> {
                attempt = Complexity.MEDIUM.attempt
                rangeNum = Complexity.MEDIUM.range
            }
            Complexity.HIGHT -> {
                attempt = Complexity.HIGHT.attempt
                rangeNum = Complexity.HIGHT.range
            }
        }
        println("Попыток = $attempt")
        println("Диапазон чисел = $rangeNum")

        // Игра
        val rand: Int = rangeNum.random()
        var userNum: Int
        var winOrLooser: String = "Вы, к сожалению, не угадали."

        for (i in 1..attempt) {
            print("Введите число: ")
            userNum = readln().toInt()
            if (rand == userNum) {
                winOrLooser = "Поздравляем Вы угадали число и выиграли"
                break
            } else if (rand < userNum) {
                println("Ваше число больше.")
                println("Осталось попыток ${attempt - i} ")
            } else {
                println("Ваше число меньше.")
                println("Осталось попыток ${attempt - i} ")
            }

        }
        println(winOrLooser)
        println()
        print("Хотите поиграть еще? (1 - Да, 0 - Нет): ")
        haveNewGame(readln().toInt())
        println()

    }
}