package com.example.dukapp

import java.util.*

data class FootballMatch(var goalsTeam1: Int = 0, var goalsTeam2: Int = 0) {
    fun setGoals(goalsTeam1: Int, goalsTeam2: Int) {
        this.goalsTeam1 = goalsTeam1
        this.goalsTeam2 = goalsTeam2
    }

    fun isDraw(): Boolean {
        return this.goalsTeam1 == this.goalsTeam2
    }

    fun goalsDifference(): Int {
        return Math.abs(this.goalsTeam1 - this.goalsTeam2)
    }
}

fun main() {
    // Создание массива из 10 матчей
    val matches = Array<FootballMatch>(10) { FootballMatch() }
    println("Matches:")
    for (i in 0 until matches.size) {
        val goalsTeam1 = Random().nextInt(6)
        val goalsTeam2 = Random().nextInt(6)
        matches[i].setGoals(goalsTeam1, goalsTeam2)
        println("Match ${i + 1}: ${matches[i]}")
    }

    // Удаление матчей с ничейными результатами
    val matchesWithoutDraws = matches.filterNot { match -> match.isDraw() }
    println("\nMatches without draws:")
    for (match in matchesWithoutDraws) {
        println(match)
    }

    // Создание множества (Set) с максимальным разрывом в голах
    val maxGoalsDifferenceMatches = matchesWithoutDraws.groupBy { match -> match.goalsDifference() }
        .maxByOrNull { (_, matches) -> matches.size }?.value ?: emptySet()
    println("\nMatches with max goals difference:")
    for (match in maxGoalsDifferenceMatches) {
        println(match)
    }
}

