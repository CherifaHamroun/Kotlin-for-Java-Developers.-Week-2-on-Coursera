package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rightpos : Int = 0
    var wrongpos : Int = 0
    var gue : String = guess
    var sec : String = secret
    var i : Int =-1
    for(s in secret) {
        if (i <3) i= i+1
        else i =0
        if (sec[i] == gue[i]){
            rightpos= rightpos +1
            gue = gue.substring(0, i )+ ' ' + gue.substring(i + 1)
            sec = sec.substring(0, i) + ' ' + sec.substring(i + 1)
        }

        for (g in guess){
                if (sec.indexOf(s) != -1 && gue.indexOf(g) != -1) {
                    if (s != gue[sec.indexOf(s)] && g != sec[gue.indexOf(g)]) {
                        if (g == s && sec.indexOf(s) != gue.indexOf(g) && sec.indexOf(s) != -1 && gue.indexOf(g) != -1) {
                            wrongpos = wrongpos + 1
                            gue = gue.substring(0, gue.indexOf(g)) + ' ' + gue.substring(gue.indexOf(g) + 1)
                            sec = sec.substring(0, sec.indexOf(s)) + ' ' + sec.substring(sec.indexOf(s) + 1)

                        }


                }
            }
        }
    }
    return Evaluation(rightpos ,wrongpos)
}
