package main

import (
	"fmt"
	"os"
	"strings"
)

func main() {
	inputFile, err := os.ReadFile("day2.txt")
	if err != nil {
		return
	}

	data := string(inputFile)
	rounds := strings.Split(data, "\n")
	points := 0

    for i := 0; i < len(rounds) - 1; i++ { 
		points += pointsForChoice(rounds[i])
		points += pointsForOutcome(rounds[i])
	}

	fmt.Println(points)
}

func pointsForChoice(round string) int {
	if strings.Contains(round, "X") {
		return 1
	}
	if strings.Contains(round, "Y") {
		return 2
	}
	return 3
}

func pointsForOutcome(round string) int {
	if strings.Contains(round, "A") {
		if strings.Contains(round, "X") {
			return 3
		}
		if strings.Contains(round, "Y") {
			return 6
		}
		return 0
	}

	if strings.Contains(round, "B") {
		if strings.Contains(round, "X") {
			return 0
		}
		if strings.Contains(round, "Y") {
			return 3
		}
		return 6
	}

	if strings.Contains(round, "X") {
		return 6
	}
	if strings.Contains(round, "Y") {
		return 0
	}
	return 3
}
