### akka-MMK-java
# Описание
- Приложение для подбора расхода электроэнергии методом ММК, исходя из количества приборов и времени их работы. Добавлена библиотека AKKA для тестирования акторной модели.
- В программе реализован класс электроприбора, в котором производится расчёт потребления электроэнергии в зависимости от количества и мощности. Также описан класс для комнаты, в котором происходит расчёт электропотребления для комнаты, он аналогичен электроприбору и также в зависимости от количества лампочек и их мощности рассчитывает суммарное электропотребление. В классе тулз описана конфигурация квартиры, указаны значения разброса количества приборов и лампочек, времени работы приборов и освещения в комнатах.
# Типы акторов
В системе два типа акторов: первый основной - управляющий, второй непосредственно перебирающий варианты - рабочий.
1. Управляющий актор имеет две ссылки на рабочих акторов, отправляет сообщения рабочим акторам о начале работы. Также ожидание от них сообщение об успешном окончании, некоторое время. Главный актор ожидает сообщения завершения от всех рабочих акторов.
2. Рабочий актор при создании в параметры получает собственное имя и количество необходимых выполнений задачи в цикле. По окончанию выполнения отсылает сообщение об успешно выполненной работе управляющему актору.
# Типы сообщений
В разработанной программе с акторной моделью для отправки сообщений управляющим актором  используется ask() метод, который отправляет сообщение со ссылкой для ответа на самого себя и по определённому времени ожидает ответа. Рабочий актор использует быстрый метод tell(), который просто отправляет сообщение без ожидания ответа.


