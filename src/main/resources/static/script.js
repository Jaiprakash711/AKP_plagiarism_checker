document.addEventListener("DOMContentLoaded", function () {
    const checkButton = document.getElementById("checkButton");
    const inputText = document.getElementById("textInput"); // FIXED ID
    const resultContainer = document.getElementById("resultContainer"); // FIXED ID
    const loadingSpinner = document.getElementById("loader"); // FIXED ID

    // Hide result container on page load
    resultContainer.style.display = "none";
    loadingSpinner.style.display = "none";

    checkButton.addEventListener("click", async function () {
        const text = inputText.value.trim();

        if (!text) {
            alert("Please enter some text.");
            return;
        }

        // Hide result and show loading spinner
        resultContainer.style.display = "none";
        loadingSpinner.style.display = "block";

        try {
            const response = await fetch("http://localhost:8080/api/plagiarism/check", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({ text }),
            });

            if (!response.ok) {
                throw new Error("Failed to fetch response");
            }

            const data = await response.json();

            // Hide loading and show result
            loadingSpinner.style.display = "none";
            resultContainer.style.display = "block";

            // Update result fields
            document.getElementById("service").textContent = data.service || "N/A";
            document.getElementById("scanTime").textContent = data.scanTime || "N/A";
            document.getElementById("inputType").textContent = data.inputType || "N/A";
            document.getElementById("score").textContent = data.score !== undefined ? data.score : "N/A";
            document.getElementById("sourceCounts").textContent = data.sourceCounts || "N/A";
            document.getElementById("textWordCounts").textContent = data.textWordCounts || "N/A";
            document.getElementById("totalPlagiarismWords").textContent = data.totalPlagiarismWords || "N/A";
            document.getElementById("identicalWordCounts").textContent = data.identicalWordCounts || "N/A";
            document.getElementById("similarWordCounts").textContent = data.similarWordCounts || "N/A";

        } catch (error) {
            console.error("Error checking plagiarism:", error);
            alert("Something went wrong! Please try again.");

            // Hide loading if error occurs
            loadingSpinner.style.display = "none";
        }
    });
});
