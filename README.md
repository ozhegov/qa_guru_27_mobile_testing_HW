# Мобильная автоматизация: запуск тестов с использованием эмулятора, реального устройства и удаленный запуск в Browserstack

## <a>**Задача:**</a>

1. Разработать автотесты на Getting started (Onboarding screen) в Android-приложении [Wikipedia](https://github.com/wikimedia/apps-android-wikipedia):
- Пройти по четырем экранам и на каждом сделать проверку
- При написании тестов использовать связку **Selenide** + **Appium**
- Удаленный запуск осуществлять через **Browserstack**
2. С помощью бибилиотеки **Owner**:
- Добавить возможность запуска на разных стендах (передать из командной строки ``` -DdeviceHost=browserstack / emulation / real```)
- Для каждого стенда сделать свой драйвер и конфигурационный файл
- Вынести данные Browserstack (логин, пароль, урл и т.д.) в конфигурационный файл
- Сделать два вида конфигурационных файлов для удаленного запуска через Browserstack на разных Android устройствах

## <a>**Реализация:**</a>

### Команды для удаленного запуска через Browserstack
- На устройстве Samsung:
```bash  
gradle clean test -DdeviceHost=browserstack -DdeviceName=samsung
```
- На устройстве Pixel:
```bash  
gradle clean test -DdeviceHost=browserstack -DdeviceName=pixel
```
### Команда для запуска на эмуляторе *
```bash  
gradle clean test -DdeviceHost=emulation
```
### Команда для запуска на реальном устройстве **
```bash  
gradle clean test -DdeviceHost=real
```
```*``` - требуется установка Android Studio и Appium Server ([инструкция](https://autotest.how/appium-setup-for-local-android-tutorial-md)) \
```**``` - требуется установка Appium Server. Также в ```realdevice.properties``` необходимо указать ```platformVersion``` и ```deviceName``` вашего утсройства
