# Download SQLite JDBC Driver
$url = "https://github.com/xerial/sqlite-jdbc/releases/download/3.44.1.0/sqlite-jdbc-3.44.1.0.jar"
$output = "lib/sqlite-jdbc-3.44.1.0.jar"

Write-Host "Downloading SQLite JDBC driver..."
Invoke-WebRequest -Uri $url -OutFile $output
Write-Host "Download completed: $output"
