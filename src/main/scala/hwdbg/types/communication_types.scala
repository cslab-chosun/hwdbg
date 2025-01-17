/**
 * @file
 *   communication.scala
 * @author
 *   Sina Karvandi (sina@hyperdbg.org)
 * @brief
 *   Data types for the communication
 * @details
 * @version 0.1
 * @date
 *   2024-04-08
 *
 * @copyright
 *   This project is released under the GNU Public License v3.
 */
package hwdbg.types

import chisel3._

//
// Structure in C:
//
// typedef struct _DEBUGGER_REMOTE_PACKET
// {
//     BYTE                                    Checksum;
//     UINT64                                  Indicator; /* Shows the type of the packet */
//     DEBUGGER_REMOTE_PACKET_TYPE             TypeOfThePacket;
//     DEBUGGER_REMOTE_PACKET_REQUESTED_ACTION RequestedActionOfThePacket;
//
// } DEBUGGER_REMOTE_PACKET, *PDEBUGGER_REMOTE_PACKET;
//

/**
 * @brief
 *   The packet used for communication with the remote debugger
 */
class DebuggerRemotePacket() extends Bundle {

  //
  // Structure fields
  //
  val Checksum = UInt(8.W) // 1 bytes
  val Alignment0 = UInt((64 - 8).W) // 7 bytes
  val Indicator = UInt(64.W) // 8 bytes
  val TypeOfThePacket = UInt(32.W) // 4 bytes
  val RequestedActionOfThePacket = UInt(32.W) // 4 bytes

  //
  // Offset of structure fields
  //
  object Offset {

    val checksum = (0) / 8

    val indicator = (Checksum.getWidth + Alignment0.getWidth) / 8

    val typeOfThePacket = (Checksum.getWidth + Alignment0.getWidth + Indicator.getWidth) / 8

    val requestedActionOfThePacket = (Checksum.getWidth + Alignment0.getWidth + Indicator.getWidth + TypeOfThePacket.getWidth) / 8

    val startOfDataBuffer =
      (Checksum.getWidth + Alignment0.getWidth + Indicator.getWidth + TypeOfThePacket.getWidth + RequestedActionOfThePacket.getWidth) / 8
  }
}

// -----------------------------------------------------------------------
