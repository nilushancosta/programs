package main

import (
    "encoding/json"
    "fmt"
    "net/http"
    "github.com/gorilla/mux"
)

func GenerateLogs(w http.ResponseWriter, r *http.Request) {
    fmt.Println("Log Entry 1")
    fmt.Println("This is a string log and was printed using fmt.Println()")
    fmt.Println("End of log Entry 1\n")

    fmt.Println("Log Entry 2")
    fmt.Println(2)
    fmt.Println("End of log Entry 2\n")

    fmt.Println("Log Entry 3")
    data := map[string]interface{}{
		"name": "John Doe",
		"age": 25,
		"hometown": "Zurich",
		"objectValue": map[string]interface{}{
			"array": []int{1, 2, 3, 4},
		},
	}
	jsonData, err := json.Marshal(data)
	if err != nil {
		fmt.Printf("Could not marshal json: %s\n", err)
		return
	}
	fmt.Println(string(jsonData))
    fmt.Println("End of log Entry 3\n")

    fmt.Println("Log Entry 4")
	fmt.Println("This log has \"double quotes\" between 2 words and was printed using fmt.Println()")
    fmt.Println("End of log Entry 4\n")

    fmt.Println("Log Entry 5")
	fmt.Println("This log has 'single quotes' between 2 words and was printed using fmt.Println()")
    fmt.Println("End of log Entry 5\n")

    fmt.Println("Log Entry 6")
	fmt.Printf("%s\n", "This is a string log and was using fmt.Printf()")
    fmt.Println("End of log Entry 6\n")
}

func main() {
    router := mux.NewRouter()

    router.HandleFunc("/", GenerateLogs).Methods("GET")

    fmt.Println("Server is running on port 8080")
    http.ListenAndServe(":8080", router)
}