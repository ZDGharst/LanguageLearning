package main

import (
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	fileContent, err := os.ReadFile("day1.txt")
	if err != nil {
		return
	}

	max := 0
	data := string(fileContent)
	elves := strings.Split(data, "\n\n")

	for _, elf := range elves {
		sum := 0
		items := strings.Split(elf, "\n")

		for _, item := range items {
            calories, _ := strconv.Atoi(item)
            sum += calories
		}

        if sum > max {
            max = sum
        }
	}

	fmt.Println(max)
}
