package aoc.one

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*
import kotlin.test.*

class CaptchaSolverTest : Spek({
    describe("a captcha solver for problem 1") {
        val solver = CaptchaSolver()
        val finalTestText = this::class.java.getResource("/one/input.txt").readText()

        it ("should convert strings to int lists") {
            assertEquals(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0), solver.toIntList("1234567890"))
        }

        it("should return 0 for no numbers") {
            assertEquals(0, solver.sum(""))
        }

        it("should return 3 for 1122") {
            assertEquals(3, solver.sum("1122"))
        }

        it("should return 4 for 1111") {
            assertEquals(4, solver.sum("1111"))
        }

        it("should return 0 for 1234") {
            assertEquals(0, solver.sum("1234"))
        }

        it("should return 9 for 91212129") {
            assertEquals(9, solver.sum("91212129"))
        }

        it("should return ? for the final input") {
            assertEquals(1089, solver.sum(finalTestText))
        }

    }
})

