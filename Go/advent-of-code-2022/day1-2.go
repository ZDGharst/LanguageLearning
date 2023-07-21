package main

import (
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

func main() {
	fileContent, err := os.ReadFile("day1.txt")
	if err != nil {
		return
	}

	data := string(fileContent)
	elves := strings.Split(data, "\n\n")
	sums := make([]int, len(elves))

	for _, elf := range elves {
		items := strings.Split(elf, "\n")
		sum := 0

		for _, item := range items {
			calories, _ := strconv.Atoi(item)
			sum += calories
		}

		sums = append(sums, sum)
	}

	sort.Sort(sort.Reverse(sort.IntSlice(sums)))

	fmt.Println(sums[0] + sums[1] + sums[2])
}
