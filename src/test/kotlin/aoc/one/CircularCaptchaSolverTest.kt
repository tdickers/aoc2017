package aoc.one

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*
import kotlin.test.*

class CircularCaptchaSolverTest : Spek({
    describe("a captcha solver for problem 2") {
        val solver = CircularCaptchaSolver()
        val finalTestText = this::class.java.getResource("/one/input.txt").readText()

        it("should return proper index when halfway digit doesn't wrap around") {
            assertEquals(4, solver.comparisonPosition(6, 1))
        }

        it("should return proper index when halfway digit does wrap around") {
            assertEquals(0, solver.comparisonPosition(6, 3))
            assertEquals(1, solver.comparisonPosition(6, 4))
            assertEquals(2, solver.comparisonPosition(6, 5))
        }

        it("should return 0 for no numbers") {
            assertEquals(0, solver.sum(""))
        }

        it("should return 6 for 1212") {
            assertEquals(6, solver.sum("1212"))
        }

        it("should return 0 for 1221") {
            assertEquals(0, solver.sum("1221"))
        }

        it("should return 4 for 123425") {
            assertEquals(4, solver.sum("123425"))
        }

        it("should return 12 for 123123") {
            assertEquals(12, solver.sum("123123"))
        }

        it("should return 4 for 12131415") {
            assertEquals(4, solver.sum("12131415"))
        }

        it("should return ? for the final input") {
            assertEquals(1156, solver.sum(finalTestText))
        }

    }
})

