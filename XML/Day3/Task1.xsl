<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
  <html>
<body>
	<h2>My Employees</h2>
	<table border="1">
    <tr bgcolor="#9acd32">
      <th align="left">Name</th>
      <th align="left">Home_Number</th>
      <th align="left">Work_Number</th>
      <th align="left">Mobile_Number</th>
      <th align="left">Street</th>
      <th align="left">Building_Number</th>
      <th align="left">Region</th>
      <th align="left">City</th>
      <th align="left">Country</th>
      <th align="left">Email</th>
    </tr>
    <xsl:for-each select="company/employee">
    <tr>
      <td><xsl:value-of select="name"/></td>
      <td><xsl:value-of select="phones/phone[@type = 'home']"/></td>
      <td><xsl:value-of select="phones/phone[@type = 'work']"/></td>
      <td><xsl:value-of select="phones/phone[@type = 'moblie']"/></td>
      <td><xsl:value-of select="addresses/address[1]/Street"/></td>
      <td><xsl:value-of select="addresses/address[1]/Building_Number"/></td>
      <td><xsl:value-of select="addresses/address[1]/Region"/></td>
      <td><xsl:value-of select="addresses/address[1]/City"/></td>
      <td><xsl:value-of select="addresses/address[1]/Country"/></td>
      <td><xsl:value-of select="e-mail"/></td>
    </tr>
    </xsl:for-each>
    </table>
</body>
</html>
  </xsl:template>
</xsl:stylesheet>