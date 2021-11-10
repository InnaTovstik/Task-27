<html>
<body>
    <form action ="#" method="POST">
        First name <input type="text" name="user_first_name" required style="margin bottom: 40px">
        <p>Last name <input type="text" name="user_last_name" required style="margin bottom: 40px"></p>
        <p>Gender</p>
        <input type="radio" name="user_gender" value = "male"> male
        <input type="radio" name="user_gender" value = "female"> female
        <input type="radio" name="user_gender" value = "other"> other
        <p>Password <input type="password" name="user_pass" required> (> 6 chars) </p>
        <p><input type="checkbox" name ="check" checked> By submitting your contact information, you agree on processing of your personal data. </p>
        <input type="submit" value="Send">
        </form>
</body>
</html>