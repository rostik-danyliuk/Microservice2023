<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teachers Information</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h2 {
            color: #333;
            text-align: center;
            margin-top: 20px;
            margin-bottom: 30px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
            background-color: #fff;
            transition: background-color 0.3s ease; /* Додаємо анімацію */
        }

        th {
            background-color: #f2f2f2;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        li {
            margin-bottom: 5px;
        }

        a {
            color: #007bff;
            text-decoration: none;
            transition: color 0.3s ease; /* Додаємо анімацію */
        }

             /* Загальні стилі для таблиці */
         table {
             width: 100%;
             border-collapse: collapse;
             margin-top: 20px;
         }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
            background-color: #fff;
            transition: background-color 0.3s ease, color 0.3s ease; /* Додавання плавної анімації */
        }

        th {
            background-color: #f2f2f2;
        }

        /* Стилі для рядка таблиці при наведенні миші */
        tr:hover {
            background-color: #e0e0e0;
        }

        /* Стилі для наведення на td (колір тексту і фону) */
        td:hover {
            background-color: #87CEFA; /* Голубий колір при наведенні */
            color: #fff; /* Колір тексту при наведенні */
        }
        th:hover {
            background-color: #FF7F7F; /* Світло червоний колір при наведенні */
            color: #fff; /* Колір тексту при наведенні */
        }
    </style>
</head>
<body>

<h2>Teachers Information</h2>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>People</th>
        <th>Position</th>
        <th>Experience</th>
        <th>Description</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <#list items as teacher>
        <tr>
            <td>${teacher.id}</td>
            <td>
                <ul>
                    <li><strong>Last Name:</strong> ${teacher.people.lastName}</li>
                    <li><strong>First Name:</strong> ${teacher.people.firstName}</li>
                    <li><strong>Patronymic:</strong> ${teacher.people.patronymic}</li>
                    <li><strong>Age:</strong> ${teacher.people.age}</li>
                </ul>
            </td>
            <td>${teacher.position}</td>
            <td>${teacher.experience}</td>
            <td>${teacher.description}</td>
            <td><a href="/ui/v1/teachers/${teacher.id}" onclick="return confirm('Are you sure you want to delete this teacher?')">Delete</a></td>
        </tr>
    </#list>
    </tbody>
</table>

</body>
</html>
