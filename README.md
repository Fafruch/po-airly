# Programowanie obiektowe - Airly REPL application

## Instrukcje:

| argument | typ | opis działania |
| ------------ | ------- | -------- |
| --latitude | double | szerokość geograficzna dowolnego punktu na mapie dla którego chcemy sprawdzić pomiary, np. `19.89323` (wymaga podania argumentu `--longitude`) |
| --longitude | double | długość geograficzna dowolnego punktu na mapie dla którego chcemy sprawdzić pomiary, np. `50.12345` (wymaga podania argumentu `--latitude`) |
| --sensor-id | int | ID sensora dla którego chcemy sprawdzić pomiary, np. `159` |
| --history | flaga | (opcjonalny) dodaje wskazania dla zeszłych 24 godzin (mierzonych co godzinę) |
| --api-key | string | (opcjonalny) własny klucz API zastępujący domyślnie wbudowany, np. `9896440101254ed89898d66d3d42c1d3` |

<br>
<br>
np. dla `--latitude=50.07918 --longitude=19.91983 --history` otrzymamy:


```
------------------------------
| Current sensor information |
------------------------------
AQI:         77.92
PM 2,5:      62.69 μg/m^3
PM 10:       107.82 μg/m^3
Pressure:    1014.53 hPa
Humidity:    87.94 %
Temperature: 1.95°C


---------------------------------
| Historical sensor information |
---------------------------------
Sensor information
between: 2018-01-10T16:59:59Z
    and: 2018-01-10T16:00:00Z

AQI:         75.17
PM 2,5:      57.24 μg/m^3
PM 10:       99.05 μg/m^3
Pressure:    1014.74 hPa
Humidity:    88.69 %
Temperature: 2.43°C


Sensor information
between: 2018-01-10T15:59:59Z
    and: 2018-01-10T15:00:00Z

AQI:         68.79
PM 2,5:      48.73 μg/m^3
PM 10:       91.24 μg/m^3
Pressure:    1014.95 hPa
Humidity:    81.22 %
Temperature: 2.93°C

...
```
