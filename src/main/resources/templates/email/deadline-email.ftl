<html>
    <head lang="en">
        <meta charset="UTF-8">
        <style type="text/css">
            .main {
                width: 100%;
                height: 630px;
                display: inline-block;
                /*background-image: url("");*/
                background-color: white;
            }
            .plate {
                padding-left: 70px;
                padding-top: 20px;
                margin: 10% auto;
                color: #696868;
            }


            .welcome{
                color: #696868;
                font-size: 18px;
                font-family: "Helvetica", bold-serif, serif;
                font-style: normal;
                margin-bottom: 1px;
            }

            .context {
                color: #696868;
                margin-top: 5px;
                font-size: 13px;
                font-family: 'Helvetica', sans-serif;
            }

            .inform {
                color: #696868;
                font-size: 14px;
                font-family: 'Helvetica', semibold;
            }
        </style>
    </head>
    <body>
        <div class="main">
            <div class="plate">
                <p class="welcome"><strong>Вітаємо, ${user}!</strong></p>
                <p class="context">Дуже раді, що ви з нами!</p>
                <br>
                <p class="inform"><strong>Це повідомлення стосується наступного пункту плану:</strong></p>
                <p class="inform"><strong>Тема:</strong> ${question}</p>
                <p class="inform"><strong>Ваші нотатки:</strong> ${answer}</p>
                <p class="inform"><strong>Повинні вас повідомити, що дедлайн вже близько!</strong></p>
                <br>
                <p class="context">Записуйте цікаві ідеї і створюйте свій бізнес план з</p>
                <p class="context">задоволенням у нашому додатку.</p>
                <p class="context">Нехай щастить!</p>
                <br>
                <br>
                <br>
                <p class="context">Якщо виникнуть будь-які запитання чи пропозиції - пишіть нам на businessplan.exec@gmai.com</p>
            </div>
        </div>
    </body>
</html>
