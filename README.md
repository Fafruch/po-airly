# Programowanie obiektowe - Airly REPL application

## Instrukcje:

| argument | typ | opis działania |
| ------------ | ------- | -------- |
| --latitude | double | szerokość geograficzna dowolnego punktu na mapie dla którego chcemy sprawdzić pomiary, np. `19.89323` (wymaga podania argumentu `--longitude`) |
| --longitude | double | długość geograficzna dowolnego punktu na mapie dla którego chcemy sprawdzić pomiary, np. `50.12345` (wymaga podania argumentu `--latitude`) |
| --sensor-id | int | ID sensora dla którego chcemy sprawdzić pomiary, np. `159` |
| --history | flaga | (opcjonalny) dodaje wskazania dla zeszłych 24 godzin (mierzonych co godzinę) |
| --api-key | string | (opcjonalny) własny klucz API zastępujący domyślnie wbudowany, np. `9896440101254ed89898d66d3d42c1d3` |


np. dla `--latitude=50.07918 --longitude=19.91983 --history` otrzymamy:


<img src="https://cdn.pbrd.co/images/H2s0wsG.png" alt="Screenshot" width="500" />
