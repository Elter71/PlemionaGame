<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Date: 09.03.2017
  Time: 09:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Game</title>
    <style>
        #container {
            margin: auto;
            width: 800px;
            height: 800px;
            background: #cccccc;
        }

        #MaterialsBar {
            background: #333;
            height: 35px;
        }

        #Materials {
            margin-left: 240px;
        }

        .Material {
            color: white;
            text-align: center;
            font-size: 16px;
            background: #000;
            margin-right: 5px;
            padding: 7px;
            height: 21px;
            float: left;
            vertical-align: middle;
            line-height: 21px;

        }

        #MaterialsBarPerH {
            background: #222;
            height: 35px;
        }

        #MaterialsPerH {
            margin-left: 15%;
        }

        .MaterialH {
            color: white;
            text-align: center;
            font-size: 16px;
            background: #000;
            margin-right: 5px;
            padding: 7px;
            height: 21px;
            float: left;
            vertical-align: middle;
            line-height: 21px;

        }

        #TimeLista {
            margin: auto;
            margin-top: 10px;
            max-width: 300px;
            min-height: 50px;
            min-width: 120px;
            background: #333333;
            border-color: darkred;
            border-radius: 5px;
        }

        #Timer {
            padding-top: 8px;
            margin: auto;
            text-align: center;
            color: white;
            width: 90%;
        }

        #mainScreen {
            margin-top: 5px;

            height: 94%;
            width: 100%;
        }

        #BuldingsList {
            margin-top: 5%;
            width: 100%;
            padding-top: 3%;
            padding-bottom: 3%;
            background: bisque;
        }

        #TableBulding {
            text-align: center;
            margin: auto;
        }

        th, td {
            padding: 5px;
        }

        .button {
            text-align: center;
            vertical-align: middle;
            background: darkred;
            width: 80px;
            height: 25px;
            border-radius: 5px;
            color: white;
            line-height: 25px;
        }

        a {
            text-decoration: none;
            color: white;
        }

        input[type = submit] {
            border: 0 none;
        }

        #messageBox {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #31708f;
            background-color: #d9edf7;
            border-color: #bce8f1;
            text-align: center;
        }


    </style>
    <script type="text/javascript">
        function Timer() {
            var dataNow = new Date();
            if (data.getHours() - dataNow.getHours() <= 0 && data.getMinutes() - dataNow.getMinutes() <= 0 && data.getSeconds() - dataNow.getSeconds() <= 0) {
                location.reload();
            }
            var Timer = new Date((data.getTime() - dataNow.getTime()) - 3600000 +1);
            console.log("TIME!! "+Timer);
            if (!isNaN(Timer))
                document.getElementById("Time").innerHTML = Timer.getHours() + ":" + Timer.getMinutes() + ":" + Timer.getSeconds();
        }
        function ShowMessage(isDisplay) {
            if (isDisplay) {
                setTimeout(function () {
                    document.getElementById("messageBox").style.display = "none";
                }, 1250);
            }

        }
        var licznik = 0;
        function TuTuTu() {
            licznik++;
            if (licznik >= 5) {
                var win = window.open("https://www.youtube.com/watch?v=fsTgudwdmgE", '_blank');
                win.focus();
                licznik = 0;
            }
        }
    </script>
</head>
<body>
<div id="container">

    <div id="MaterialsBar">
        <div id="Materials">
            <div class="Material">Drewno: ${amount.get(0)}</div>
            <div class="Material">Kamień: ${amount.get(1)}</div>
            <div class="Material">Jedzenie: ${amount.get(2)}</div>
            <div class="button" style="float: right">
                <a href="<c:url value="/game/menu" />">MENU</a>
            </div>
            <div style="clear: both;"></div>
        </div>
    </div>
    <div id="MaterialsBarPerH">
        <div id="MaterialsPerH">
            <div class="MaterialH">Drewno na godzine: ${MaterialsPerHours.get(0)}</div>
            <div class="MaterialH">Kamień na godzine: ${MaterialsPerHours.get(1)}</div>
            <div class="MaterialH">Jedzenie na godzine: ${MaterialsPerHours.get(2)}</div>
            <div style="clear: both;"></div>
        </div>
    </div>


    <div id="mainScreen">
        <c:if test="${not empty message}">
            <div id="messageBox">${message}
                <script>
                    ShowMessage(true);
                </script>
            </div>
        </c:if>
        <div id="TimeLista">
            <div id="Timer"><c:if test="${not (GameInformation.get(1).equals('null'))}">${GameInformation.get(1)}</c:if>
                <span id="Time">${GameInformation.get(0)}</span>
            </div>
        </div>
        <div id="BuldingsList">
            <table id="TableBulding">
                <tr>
                    <th>Nazwa budynku</th>
                    <th>Poziom</th>
                    <th>Potrzebne Drewno</th>
                    <th>Potrzebny Kamień</th>
                    <th>Potrzebne Jedzenie</th>
                    <th>Czas Budowy</th>
                    <th></th>
                </tr>
                <tr class="BuldingTr">
                    <td>Tartak</td>
                    <td>${SawmillList.get(0)}</td>
                    <td>${SawmillList.get(1)}</td>
                    <td>${SawmillList.get(2)}</td>
                    <td>${SawmillList.get(3)}</td>
                    <td>${SawmillList.get(4)}</td>
                    <td>
                        <div class="button"><a href="<c:url value="/game/1" />">Buduj</a></div>
                    </td>
                </tr>
                <tr class="BuldingTr">
                    <td>Farma</td>
                    <td>${FarmList.get(0)}</td>
                    <td>${FarmList.get(1)}</td>
                    <td>${FarmList.get(2)}</td>
                    <td>${FarmList.get(3)}</td>
                    <td>${FarmList.get(4)}</td>
                    <td>
                        <div class="button"><a href="<c:url value="/game/2" />">Buduj</a></div>
                    </td>
                </tr>

                <tr class="BuldingTr">
                    <td onclick="TuTuTu()">Kamieniołom</td>
                    <td>${StonePitList.get(0)}</td>
                    <td>${StonePitList.get(1)}</td>
                    <td>${StonePitList.get(2)}</td>
                    <td>${StonePitList.get(3)}</td>
                    <td>${StonePitList.get(4)}</td>
                    <td>
                        <div class="button"><a href="<c:url value="/game/3" />">Buduj</a></div>
                    </td>
                </tr>
                <tr class="BuldingTr">
                    <td>Stworzenie wioski</td>
                    <td>${Village.get(0)}</td>
                    <td>${Village.get(1)}</td>
                    <td>${Village.get(2)}</td>
                    <td>${Village.get(3)}</td>
                    <td>${(Village.get(4)/3600)}H</td>
                    <td>
                        <div class="button"><a href="<c:url value="/game/99" />">Buduj</a></div>
                    </td>

                </tr>
            </table>


        </div>
        <script type="text/javascript">
            setInterval(Timer, 1000);
            var data = new Date(parseInt(document.getElementById("Time").textContent));
            document.getElementById("Time").innerHTML = "";
            Timer();
        </script>

        <%--<% response.setHeader("Refresh", "1; URL=/GameP/game/" );  %>--%>


    </div>

</div>

</body>
</html>
