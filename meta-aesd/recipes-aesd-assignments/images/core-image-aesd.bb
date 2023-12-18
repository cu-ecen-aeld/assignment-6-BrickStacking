inherit core-image
#CORE_IMAGE_EXTRA_INSTALL += "aesd-assignments"
CORE_IMAGE_EXTRA_INSTALL += "openssh"
inherit extrausers
# See https://docs.yoctoproject.org/singleindex.html#extrausers-bbclass
# We set a default password of root to match our busybox instance setup
# Don't do this in a production image
# PASSWD below is set to the output of
# printf "%q" $(mkpasswd -m sha256crypt root) to hash the "root" password
# string
PASSWD = "\$5\$WNoEDG.8KThD6\$U/.GO3YUFciS73l/7Hks.bY6NgflAzYl6lZt5jc1EB2tohashtherootpassword"
EXTRA_USERS_PARAMS = "usermod -p '${PASSWD}' root;"
