# B-TSIKT

Praktické cvičenia k predmetu (predpoklad) TSIKT – základné Java úlohy rozdelené podľa týždňov / cvičení. Repozitár obsahuje jednoduché príklady na zoznámenie sa so syntaxou Javy: výpisy na konzolu, cykly, podmienky, práca s metódami a postupné zvyšovanie zložitosti.


## VS Code – rýchly štart

Tento workspace je pripravený na prácu s Javou vo VS Code:

- Odporúčané rozšírenia sú v `.vscode/extensions.json` (Extension Pack for Java atď.).
- JDK 21 je nastavené v `.vscode/settings.json`.
- Debug konfigurácia „Java: Launch Current File“ je v `.vscode/launch.json`.

### Spustenie aktuálne otvoreného súboru

1) Otvorte `.java` súbor s metódou `public static void main`.
2) Stlačte F5 (alebo Run and Debug → Java: Launch Current File).

### Build/Run cez Tasks

- Build aktuálneho súboru do priečinka `bin`:

```powershell
Tasks: Run Task → "javac: compile current file to bin"
```

- Spustiť aktuálny súbor (zohľadní balíček podľa cesty):

```powershell
Tasks: Run Task → "java: run current file from bin"
```

### Ručné spustenie v termináli (Windows PowerShell)

```powershell
javac -d bin "<cesta k súboru>.java"
java -cp bin <balicek>.<<NazovTriedy>>
```

Príklad pre `Cvik4/Uloha3/Uloha3.java`:

```powershell
javac -d bin "Cvik4/Uloha3/Uloha3.java"
java -cp bin Cvik4.Uloha3.Uloha3
```

