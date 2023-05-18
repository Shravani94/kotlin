package com.techouts

class RegularExpression {
    fun containsMatch() {
        val regl = Regex(pattern = "Beautiful")
        val matched = regl.containsMatchIn("Sravani is Beautiful girl")
        println()
        println("containsMatch() Example")
        println(
            "macthes is matched $matched"
        )
    }

    fun matches() {
        var regl = """a([bc]+)d?""".toRegex()
        val match1 = regl.matches("adecvgdg")
        val match2 = regl.matches("abcd")
        val match3 = regl.matches("abdceg")
        println()
        println("matches() Example")
        println("match1 is matched $match1")
        println("match2 is matched $match2")
        println("match3 is matched $match3")
    }

    fun entairematch() {
        var regul = Regex(pattern = "abcd")
        val match1 = regul.matchEntire("kjasgdwuyebcn")
        val match2 = regul.matchEntire("abcd")
        val match3 = Regex("""\d""").matchEntire("100");
        val match4 = Regex(pattern = """\d""").matchEntire("100 dolors")
        println()
        println("entaireMatch() Example")
        println("entaire match is matched $match1")
        println("entaire match is matched $match2")
        println("entaire match is matche $match3")
        println("entaire match is matched $match4")
    }

    fun findall() {
        var regex = Regex(pattern = """\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,6}""")
        var mailId: String? = regex.find("my mailId is sravani@google.com")?.value
        var regex1 = Regex(pattern = """\d{3}-\d{3}-\d{4}""")
        var mobile: String? = regex1.find("my mobile number is 123-123-1234")?.value
        var mobile2: String? = regex1.find("gdkhlj;ljkgjhfjg")?.value
        println()
        println("findAll() example")
        println("mailId is $mailId")
        println("mobile number is $mobile")
        println("mobile2 number is $mobile2")
    }

    fun offindAll() {
        var regex = Regex(pattern = """\d""").findAll("aa12bb13cc14dd15")
        var result = StringBuffer()
        for (foundText in regex) {
            result.append(foundText.value + "")
        }
        println()
        println("offindAll() example")
        println("The result is $result")
    }

    fun ofReplace() {
        val regex = Regex("easy")
        var afterReplacement = regex.replace("kotlin is easy language", "dead easy")
        println()
        println("ofReplace() example")
        println("After replacements the value is $afterReplacement")
    }

    fun firstReplace() {
        var replacement = Regex("not easy")
        var replace = replacement.replaceFirst("kotlin is not easy to learn ,not easy to implement ", "easy")
        println()
        println("replaceFirst() example")
        println("after replacement" + replace)
    }

    fun split() {
        var regex = Regex("""\d""").split("ad12se2fr5gt")
        var regex1 = Regex("""\d""").split("this is String ")
        println()
        println("split() example")
        println(regex)
        println(regex1)

    }
}
fun main(args:Array<String>)
{
    val obj=RegularExpression()
    obj.containsMatch()
    obj.matches()
    obj.entairematch()
    obj.findall()
    obj.offindAll()
    obj.ofReplace()
    obj.firstReplace()
    obj.split()
}