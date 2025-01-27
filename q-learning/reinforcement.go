package main

import (
	"fmt"
	"math"
	"math/rand"
)

func QTable() [][]float64 {

	// creates a table of four rows
	matrix := make([][]float64, 4)
	for i := 0; i < 4; i++ {

		// adds four columns to the row
		matrix[i] = make([]float64, 4)

		// adds random numbers to each column
		for j := 0; j < 4; j++ {
			matrix[i][j] = math.Ceil(rand.Float64()*100) / 100
		}
	}

	fmt.Println("The Q-learning Table: ")
	for _, row := range matrix {
		fmt.Println(row)
	}

	return matrix

}

func main() {

	// generating a random q-table
	QTable()
}
