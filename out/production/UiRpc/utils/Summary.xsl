<?xml version="1.0" encoding="UTF-8"?>
<!-- This file is for testcase summary xml-->
<!DOCTYPE xsl:stylesheet [ <!ENTITY nbsp "&#160;"> ]>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
    <xsl:output version="1.0" indent="yes" encoding="UTF-8" method="html"/>
    <xsl:template match="/">
        <html>
 			<body topmargin="0">
				<table id="Table_01" width="100%" height="49" border="1" cellpadding="0" cellspacing="0">
					<tr>
						<th>Name</th>
						<th>Cycle</th>
						<th>Result</th>
						<th>Detail</th>
					</tr>
					<xsl:for-each select="TestCaseSummary/TestCase">
					<tr>
						<xsl:variable name="Color">
							<xsl:value-of select="Result"/>
						</xsl:variable>
						<xsl:variable name="hyperlink">
								<xsl:value-of select="Detail"/>
						</xsl:variable>
						<xsl:choose>
							<xsl:when test="$Color='Passed'">
								<td bgcolor="#00FF00">
								<xsl:value-of select="Name"/></td>
							</xsl:when>
							<xsl:otherwise>
								<td bgcolor="#FF0000">
								<xsl:value-of select="Name"/></td>
							</xsl:otherwise>
						</xsl:choose>	
						<xsl:choose>
							<xsl:when test="$Color='Passed'">
								<td bgcolor="#00FF00">
								<xsl:value-of select="Cycle"/></td>
							</xsl:when>
							<xsl:otherwise>
								<td bgcolor="#FF0000">
								<xsl:value-of select="Cycle"/></td>
							</xsl:otherwise>
						</xsl:choose>	
						<xsl:choose>
							<xsl:when test="$Color='Passed'">
								<td bgcolor="#00FF00">
								<xsl:value-of select="Result"/></td>
							</xsl:when>
							<xsl:otherwise>
								<td bgcolor="#FF0000">
								<xsl:value-of select="Result"/></td>
							</xsl:otherwise>
						</xsl:choose>	
						<xsl:choose>
							<xsl:when test="$Color='Passed'">
								<td bgcolor="#00FF00">
									<xsl:variable name="hyperlink">
										<xsl:value-of select="Detail"/>
									</xsl:variable>
									<a href="{$hyperlink}">
										<xsl:value-of select="Detail"/>
									</a>
								</td>
							</xsl:when>
							<xsl:otherwise>
								<td bgcolor="#FF0000">
									<xsl:variable name="hyperlink">
										<xsl:value-of select="Detail"/>
									</xsl:variable>
									<a href="{$hyperlink}">
										<xsl:value-of select="Detail"/>
									</a>
								</td>													
							</xsl:otherwise>
						</xsl:choose>
					</tr>
					</xsl:for-each>
                </table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>	
				
