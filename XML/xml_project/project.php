<!DOCTYPE html>
<html>

<head>
    <title>Form</title>
    <style>
    input[type=text],input[type=number] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        box-sizing: border-box;
    }

    label {
        font-weight: bold;
    }

    input[type=submit] {
        background-color: #04AA6D;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    </style>
</head>

<body>
    <?php
    session_start();
$i = 0;
$employees[] = simplexml_load_file('project.xml');
if (isset($_POST['insert'])) {
    $xml = new DOMDocument("1.0", "UTF-8");
    $xml->load("project.xml");
    $rootTag = $xml->getElementsByTagName("employees")->item(0);
    $employeeTag = $xml->createElement("employee");
    $nameTag = $xml->createElement("name", $_POST['name']);
    $phoneTag = $xml->createElement("phone", $_POST['phone']);
    $addressTag = $xml->createElement("address", $_POST['address']);
    $emailTag = $xml->createElement("email", $_POST['email']);
    $employeeTag->appendChild($nameTag);
    $employeeTag->appendChild($phoneTag);
    $employeeTag->appendChild($addressTag);
    $employeeTag->appendChild($emailTag);
    $rootTag->appendChild($employeeTag);
    $xml->save("project.xml");
}

if (isset($_POST['update'])) {
    $employees = simplexml_load_file('project.xml');
    foreach ($employees->employee as $employee) {
        if ($employee->name == $_POST['name']) {
            $employee->phone = $_POST['phone'];
            $employee->address = $_POST['address'];
            $employee->email = $_POST['email'];
            break;
        }
    }
    file_put_contents('project.xml', $employees->asXML());
    header("location: project.php");
}

if (isset($_POST['delete'])) {
    $employees = simplexml_load_file('project.xml');
    $index = 0;
    foreach ($employees->employee as $employee) {
        if ($employee->name == $_POST['name']) {
            unset($employees->employee[$index]);
            break;
        }
        $index++;
    }
    file_put_contents('project.xml', $employees->asXML());
    header('location: project.php');
}

if (isset($_POST['prev'])) {
    if ($_SESSION['id'] <= 0) {
        $i = 0;
        $_SESSION['id'] = $i;
    } else {
        $_SESSION['id'] = $_SESSION['id'] - 1;
        $i = $_SESSION['id'];
    }
}

if (isset($_POST['next'])) {
    if (isset($_SESSION['id'])) {
        $_SESSION['id'] = $_SESSION['id'] + 1;
        if ($_SESSION['id'] < count($employees[0]->employee)) {
            $i = $_SESSION['id'];
        } else {
            $i = count($employees[0]->employee)-1;
            $_SESSION['id'] = count($employees[0]->employee)-1;
        }
    } else {
        $i++;
        $_SESSION['id'] = $i;
    }
}

if (isset($_POST["search"])) {
    $employees = simplexml_load_file('project.xml');
    foreach ($employees as $employee) {
        if (strcmp($employee->name, $_POST['name']) == 0) {
            echo "<center> <h3>You searched for employee:</h3>
            Name: $employee->name</br>
            Phone: $employee->phone</br>
            Address: $employee->address</br>
            Email: $employee->email </center>";
        }
    }
}
?>
    <form action="project.php" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="<?php echo $employees[0]->employee[$i]->name; ?>">
        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" value="<?php echo $employees[0]->employee[$i]->phone; ?>">
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="<?php echo $employees[0]->employee[$i]->address; ?>">
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" value="<?php echo $employees[0]->employee[$i]->email; ?>">
        <input type="submit" name="insert" value="Insert">
        <input type="submit" name="update" value="Update">
        <input type="submit" name="delete" value="Delete">
        <input type="submit" name="search" value="Search by name">
        <input type="submit" name="prev" value="Previous">
        <input type="submit" name="next" value="Next">
    </form>

</body>

</html>