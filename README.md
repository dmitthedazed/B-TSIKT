<div align="center">

# B-TSIKT

Weekly Java exercises for the course *Tvorba softvéru v IKT*, from console output to a small SQLite app.

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk&logoColor=white&style=flat-square)
[![Tests](https://img.shields.io/github/actions/workflow/status/dmitthedazed/B-TSIKT/tests.yml?style=flat-square&label=Tests)](https://github.com/dmitthedazed/B-TSIKT/actions/workflows/tests.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-lightgrey?style=flat-square)](LICENSE)

</div>

> [!NOTE]
> Archived. The course is over, so this repository is read-only and kept for reference.

## Contents

- `Cvik1`–`Cvik9`: one folder per class, numbered tasks inside.
- `lib/`: `sqlite-jdbc` driver for the database exercises.
- Semester project: [B-TSIKT_Semestralne-Zadanie](https://github.com/dmitthedazed/B-TSIKT_Semestralne-Zadanie).

## Assignments

| Class | Task | Topic | Source |
| --- | --- | --- | --- |
| 1 | 1 | Hello World | [Uloha1_HelloWorld.java](Cvik1/Uloha1_HelloWorld.java) |
| 1 | 2 | Loop from 1 to 100 | [Uloha2_Loop_1to100.java](Cvik1/Uloha2_Loop_1to100.java) |
| 2 | 2 | Control flow: sign and zero checks | [Uloha2.java](Cvik2/Uloha2.java) |
| 3 | 1 | Prime number check | [Uloha1.java](Cvik3/Uloha1.java) |
| 3 | 2 | Sum of numbers | [Uloha2.java](Cvik3/Uloha2.java) |
| 3 | 3 | Four-operation calculator | [Uloha3.java](Cvik3/Uloha3.java) |
| 4 | 1 | String operations (length, compare, search, case) | [Uloha1/](Cvik4/Uloha1/) |
| 4 | 2 | String operations (remove spaces, split, replace, palindrome) | [Uloha2/](Cvik4/Uloha2/) |
| 4 | 3 | Employee class | [Uloha3.java](Cvik4/Uloha3/Uloha3.java) |
| 5 | 1, 2 | Inheritance: Animal, Cat, Dog | [Uloha1_2/](Cvik5/Uloha1_2/) |
| 5 | 3 | Abstract Shape, Circle, Rectangle | [Uloha3/](Cvik5/Uloha3/) |
| 6 | 1 | Enums: seasons by month | [Uloha1/](Cvik6/Uloha1/Uloha1_Enums.java) |
| 6 | 1, 2 (example) | Interface Vehicle | [Uloha1_2_Priklad.java](Cvik6/Uloha1_2_Priklad.java) |
| 6 | 3 | Inheritance: Animal, Bird, Cat, Dog | [Uloha3/](Cvik6/Uloha3/) |
| 6 | 4 | Vehicles, electric car, fuel type enum | [Uloha4/](Cvik6/Uloha4/) |
| 7 | 1 | Objects: Zamestnanec | [Uloha1/](Cvik7/Uloha1/) |
| 7 | 2 | Customer management | [Uloha2/](Cvik7/Uloha2/) |
| 7 | 3 | Dictionary with HashMap | [Uloha3/](Cvik7/Uloha3/) |
| 8 | 1 | Division with exception handling | [Uloha1.java](Cvik8/Uloha1.java) |
| 8 | 2 | Reading an integer from input | [Uloha2.java](Cvik8/Uloha2.java) |
| 8 | 3 | Custom exception for age check | [Uloha3.java](Cvik8/Uloha3.java) |
| 8 | 4 | Temperature conversion class | [Uloha4.java](Cvik8/Uloha4.java) |
| 9 | 1 | SQLite database: table, students | [Uloha1.java](Cvik9/Uloha1.java) |

## Running

In VS Code, open a `.java` file with `main` and press F5.

In a terminal (example: `Cvik4/Uloha3/Uloha3.java`):

```bash
javac -d bin "Cvik4/Uloha3/Uloha3.java"
java -cp bin Cvik4.Uloha3.Uloha3
```

Database exercises need the driver on the classpath:

```bash
javac -cp "lib/*" -d bin "Cvik9/Uloha1.java"
java -cp "bin:lib/*" Cvik9.Uloha1
```

## License

[MIT](LICENSE) © Dmytrii Savin
