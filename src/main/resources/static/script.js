function checkPlagiarism() {
    const text = document.getElementById("textInput").value;
    if (!text) {
        alert("Please enter text to check.");
        return;
    }

    fetch("http://localhost:8080/api/plagiarism/check", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ text: text })
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById("result").innerHTML = `
            <p>Plagiarism Score: ${data.score}%</p>
            <p>Sources Found: ${data.sourceCounts}</p>
            <p>Total Words: ${data.textWordCounts}</p>
            <p>Plagiarized Words: ${data.totalPlagiarismWords}</p>
            <p>Identical Words: ${data.identicalWordCounts}</p>
            <p>Similar Words: ${data.similarWordCounts}</p>
        `;
    })
    .catch(error => {
        console.error("Error:", error);
        alert("Failed to check plagiarism. Try again later.");
    });
}
