require vuplus-blindscan-utils.inc

do_install() {
	install -d "${D}/${bindir}"
	install -m 0755 "${S}/tda1002x" "${D}/${bindir}"
}

SRC_URI[md5sum] = "5bf4975a46f7af78994534d1629ddc7a"
SRC_URI[sha256sum] = "ad7e79b424968e382e29b8f5fe97e4164922771624f30c2b2fa5d8ed198c400f"
