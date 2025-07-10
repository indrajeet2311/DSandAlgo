# DSandAlgo
Solving Data Structures and Algorithms 

import React from "react";
import { Box } from "@mui/material";

import Header from "../Header";
import DashboardHeader from "./DashBoardHeader";
import DashboardCards from "./DashboardCards";
import TestStatistics from "./TestStatistics";
import DestinationStats from "./DestinationStats";
import RecentTestCases from "./RecentTestCases";

export default function Dashboard() {
  return (
    <>
      <DashboardHeader />

          <DashboardCards />
       

      {/* Second Row: Test Statistics & Destination Stats */}
      <Box
        sx={{
          display: 'flex',
          flexDirection: 'row',
          gap: 4,
          p: 2,
          flexWrap: 'wrap',
        }}
      >
        <Box sx={{ flex: 1}}>
          <TestStatistics />
        </Box>
        <Box sx={{ flex: 1 }}>
          <DestinationStats />
        </Box>

     
      </Box>


      <Box sx={{ flex: 1}}>
          <RecentTestCases />
        </Box>
    </>
  );
}
