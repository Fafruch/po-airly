# Programowanie obiektowe - Airly REPL application

## Instrukcje:

| argument | typ | opis działania |
| ------------ | ------- | -------- |
| --latitude | double | szerokość geograficzna dowolnego punktu na mapie dla którego chcemy sprawdzić pomiary, np. `19.89323` (wymaga podania argumentu `--longitude`) |
| --longitude | double | długość geograficzna dowolnego punktu na mapie dla którego chcemy sprawdzić pomiary, np. `50.12345` (wymaga podania argumentu `--latitude`) |
| --sensor-id | int | ID sensora dla którego chcemy sprawdzić pomiary, np. `159` |
| --history | flaga | (opcjonalny) dodaje pomiary dla zeszłych 24 godzin (mierzonych co godzinę) |
| --api-key | string | (opcjonalny) zapytania do serwera Airly będą używały podanego klucza `API_KEY`, np. `9896440101254ed89898d66d3d42c1d3` (domyślnie wartość klucza pobierana jest ze zmiennej środowiskowej `API_KEY`) |

<br>
<br>

np. dla `--latitude=50.07918 --longitude=19.91983 --history` otrzymamy:

<br>

```
----------------------------------
|   Current sensor information   |
----------------------------------

             ______
            /      \
           /  ^  ^  \
           \  \__/  /
            \______/

AQI:         44.34
PM 2,5:      27.94 μg/m^3
PM 10:       55.28 μg/m^3
Pressure:    1028.21 hPa
Humidity:    90.21 %
Temperature: -0.07°C


-----------------------------------
|  Historical sensor information  |
-----------------------------------


Sensor information
between:       2018-01-12T09:59:59Z
    and:       2018-01-12T09:00:00Z
    
             ______
            /      \
           /  o  o  \
           \  .__.  /
            \______/

AQI:         51.01
PM 2,5:      31.24 μg/m^3
PM 10:       64.15 μg/m^3
Pressure:    1028.04 hPa
Humidity:    92.7 %
Temperature: -0.16°C



-----------------------------------


Sensor information
between:       2018-01-12T08:59:59Z
    and:       2018-01-12T08:00:00Z
    
             ______
            /      \
           /  o  o  \
           \  .__.  /
            \______/

AQI:         50.42
PM 2,5:      31.69 μg/m^3
PM 10:       65.22 μg/m^3
Pressure:    1027.45 hPa
Humidity:    92.41 %
Temperature: 0.26°C



-----------------------------------


...
```

(i to w kolorkach)
