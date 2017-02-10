SUMMARY = "Phosphor DBus Interfaces"
DESCRIPTION = "Generated bindings, using sdbus++, for the phosphor YAML"
PR = "r1"

S = "${WORKDIR}/git"

inherit autotools pkgconfig
inherit obmc-phosphor-license
inherit pythonnative

DEPENDS += "autoconf-archive-native"
DEPENDS += "sdbus++-native"

PACKAGE_BEFORE_PN = "${PN}-yaml"

FILES_${PN}-yaml = "${datadir}/${PN}/yaml"

SRC_URI += "git://github.com/openbmc/phosphor-dbus-interfaces"
SRCREV = "06e5b23a3671f44c04c7f7cce83def5ff68c86b9"

DEPENDS_remove_class-native = "sdbus++-native"
DEPENDS_remove_class-nativesdk = "sdbus++-native"

PACKAGECONFIG ??= "libphosphor_dbus"
PACKAGECONFIG[libphosphor_dbus] = "--enable-libphosphor_dbus,--disable-libphosphor_dbus,sdbusplus,libsystemd"

PACKAGECONFIG_remove_class-native = "libphosphor_dbus"
PACKAGECONFIG_remove_class-nativesdk = "libphosphor_dbus"

BBCLASSEXTEND += "native nativesdk"