<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Artist Registration</title>
</head>
<body>
    <form action="artist" method="POST">
        UserName: <input type="text" name="uname" id="uname"><br>

        PassWord: <input type="password" name="pass" id="pass"><br>

        <!-- Sector Dropdown -->
        Sector: 
        <select name="sector" id="sector">
            <option value="painting">Painting</option>
            <option value="food">Food</option>
            <option value="music">Music</option>
            <option value="dance">Dance</option>
            <option value="craft">Craft</option>
            <!-- Add more sectors as needed -->
        </select><br>

        <!-- Skill Tag Input -->
        Skill Tag: <input type="text" name="skill_tag" id="skill_tag"><br>

        <!-- Certification Option -->
        Certification:
        <input type="radio" name="certification" value="yes" id="cert_yes" onclick="toggleCertification(true)"> Yes
        <input type="radio" name="certification" value="no" id="cert_no" onclick="toggleCertification(false)" checked> No<br>

        <!-- Certificate Name (visible only if certification is Yes) -->
        <div id="cert_name_div" style="display:none;">
            Certificate Name: <input type="text" name="cert_name" id="cert_name"><br>
        </div>

        <button type="submit">Register</button>
    </form>

    <script>
        // Function to toggle the visibility of the certificate name field
        function toggleCertification(isCertified) {
            if (isCertified) {
                document.getElementById("cert_name_div").style.display = "block";
            } else {
                document.getElementById("cert_name_div").style.display = "none";
            }
        }
    </script>
</body>
</html>
