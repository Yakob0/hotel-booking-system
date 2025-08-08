# SQLite JDBC Driver

To download the SQLite JDBC driver, run one of these commands:

## Option 1: Using PowerShell
```powershell
Invoke-WebRequest -Uri "https://github.com/xerial/sqlite-jdbc/releases/download/3.44.1.0/sqlite-jdbc-3.44.1.0.jar" -OutFile "sqlite-jdbc-3.44.1.0.jar"
```

## Option 2: Using curl (if available)
```bash
curl -L -o sqlite-jdbc-3.44.1.0.jar https://github.com/xerial/sqlite-jdbc/releases/download/3.44.1.0/sqlite-jdbc-3.44.1.0.jar
```

## Option 3: Manual download
1. Visit: https://github.com/xerial/sqlite-jdbc/releases
2. Download the latest version (sqlite-jdbc-3.44.1.0.jar)
3. Place it in this lib folder

## Compilation with JAR
Once the JAR is downloaded, compile your Java files with:
```bash
javac -cp "lib/*" SRC/dao/*.java SRC/MODEL/*.java SRC/MODEL/ui/*.java
```

## Running with JAR
```bash
java -cp "lib/*;." ui.MainMenu
```
