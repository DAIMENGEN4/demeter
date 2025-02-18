import "./schedule.scss";
import React, {useCallback, useEffect, useState} from "react";
import {Button, Dropdown, Layout, Menu, Space} from "antd";
import {Outlet, useNavigate} from "react-router-dom";
import {LeftOutlined, RightOutlined} from "@ant-design/icons";
import {HouseIcon01} from "@D/icons/house-icon/house-icon-01";
import {PRIMARY_COLOR} from "@D/theme/theme";
import {ScheduleIcon01} from "@D/icons/schedule-icon/schedule-icon-01";
import {StarIcon02} from "@D/icons/star-icon/star-icon-02";
import {WorkspaceIcon01} from "@D/icons/workspace-icon/workspace-icon-01";
import {MoreIcon01} from "@D/icons/more-icon/more-icon-01";
import {AddIcon01} from "@D/icons/add-icon/add-icon-01";
import {SortIcon01} from "@D/icons/sort-icon/sort-icon-01";
import {ImportIcon01} from "@D/icons/import-icon/import-icon-01";
import {PersistentDropdown} from "@D/components/persistent-dropdown/persistent-dropdown.tsx";
import {CreateSchedule} from "@D/components/schedule/create-schedule/create-schedule.tsx";
import {ProjectDTO, ProjectService} from "@D/http/service/project-service.ts";
import {log} from "@D/logging.ts";
import {useDemeterDispatch} from "@D/store/store.ts";
import {setProjectDTOS} from "@D/store/features/project-slice.ts";
import {useProjectVo} from "@D/hooks/project/use-project-vo.tsx";

export const Schedule: React.FC = () => {
    const {Sider} = Layout;
    const projects = useProjectVo();
    const navigate = useNavigate();
    const dispatch = useDemeterDispatch();
    const [collapsed, setCollapsed] = useState(false);
    const [selectedKeys, setSelectedKeys] = useState<Array<string>>(["schedule-home"]);
    const truncateString = useCallback((str: string, maxLength: number) => {
        if (str.length > maxLength) {
            return str.substring(0, maxLength) + '...';
        } else {
            return str;
        }
    }, []);
    useEffect(() => {
        ProjectService.getInstance().getProjectsByCurrentEmployeeRequest((projectDTOS: Array<ProjectDTO>) => {
            dispatch(setProjectDTOS(projectDTOS));
        }, error => log.error(error.message))
    }, [dispatch]);
    return (
        <Layout className={"schedule"} hasSider={true}>
            <Sider theme={"light"} className={"schedule-sider"} trigger={null} collapsible collapsed={collapsed}>
                <div className={"schedule-sider-trigger"} onClick={() => setCollapsed(!collapsed)}>
                    {collapsed ? <RightOutlined/> : <LeftOutlined/>}
                </div>
                <Menu className={"schedule-sider-menu"}
                      mode="inline"
                      selectedKeys={selectedKeys}
                      onClick={(e) => {
                          setSelectedKeys([e.key]);
                          switch (e.key) {
                              case "home":
                                  navigate("/home/schedule");
                                  break;
                              case "work":
                                  // navigate("/schedule-page/my-work");
                                  break;
                          }
                      }}
                      items={[
                          {
                              key: 'divider-1',
                              type: 'divider',
                          },
                          {
                              key: 'home',
                              icon: <HouseIcon01 width={16} height={16}
                                                 color={selectedKeys.includes("home") ? PRIMARY_COLOR : "#1d1d1d"}/>,
                              label: <div>Schedule home</div>
                          },
                          {
                              key: 'divider-2',
                              type: 'divider',
                          },
                          {
                              key: 'work',
                              icon: <ScheduleIcon01 width={16} height={16}
                                                    color={selectedKeys.includes("work") ? PRIMARY_COLOR : "#1d1d1d"}/>,
                              label: <div>My work</div>
                          },
                          {
                              key: 'divider-3',
                              type: 'divider',
                          },
                          {
                              key: 'favorites',
                              icon: <StarIcon02 width={16} height={16}
                                                color={selectedKeys.includes("favorites") ? PRIMARY_COLOR : "#1d1d1d"}/>,
                              label: 'Favorites',
                          },
                          {
                              key: 'divider-4',
                              type: 'divider',
                          },
                          {
                              key: 'workspace',
                              icon: <WorkspaceIcon01 width={16} height={16}
                                                     color={selectedKeys.includes("workspace") ? PRIMARY_COLOR : "#1d1d1d"}/>,
                              label: <Space size={"small"}>
                                  <div>Workspace</div>
                                  <PersistentDropdown trigger={["click"]} menu={{
                                      items: [
                                          {
                                              key: "create-schedule",
                                              label: <CreateSchedule/>,
                                              icon: <AddIcon01 width={15} height={15} color={"#2c2c2c"}/>
                                          },
                                          {
                                              key: "sort-schedule",
                                              label: <span>Sort schedule</span>,
                                              icon: <SortIcon01 width={15} height={15} color={"#2c2c2c"}/>,
                                          },
                                          {
                                              key: "import-schedule",
                                              label: <span>Import schedule</span>,
                                              icon: <ImportIcon01 width={15} height={15}
                                                                  color={"#2c2c2c"}/>,
                                          },
                                          {
                                              type: 'divider',
                                          },
                                          {
                                              key: '3',
                                              label: '3rd menu item',
                                          },
                                      ],
                                      onClick: (e) => {
                                          e.domEvent.stopPropagation();
                                          switch (e.key) {
                                              case "create-schedule":
                                                  // dispatch(setCreateScheduleModalVisible(true));
                                                  break;
                                              case "sort-schedule":
                                                  break;
                                              case "import-schedule":
                                                  break;
                                              default:
                                                  break;
                                          }
                                      }
                                  }}>
                                      <Button type={"text"}
                                              style={{width: 25, height: 25}}
                                              onClick={(e) => e.stopPropagation()}
                                              icon={<MoreIcon01 width={16} height={16}
                                                                color={"#2c2c2c"}/>}/>
                                  </PersistentDropdown>
                              </Space>,
                              children: projects.map(project => ({
                                  key: project.getId(),
                                  label: <Dropdown trigger={["contextMenu"]} menu={{
                                      items: [
                                          {
                                              key: `${project.getId()}-open-in-new-table`,
                                              label: 'Open in New Tab'
                                          },
                                          {key: `${project.getId()}-divider-1`, type: 'divider'},
                                          {
                                              key: `${project.getId()}-rename-schedule`,
                                              label: 'Rename Schedule'
                                          },
                                          {
                                              key: `${project.getId()}-add-to-favorites`,
                                              label: 'Add to Favorites'
                                          },
                                          {
                                              key: `${project.getId()}-save-as-a-template`,
                                              label: 'Save as a Template'
                                          },
                                          {key: `${project.getId()}-divider-2`, type: 'divider'},
                                          {
                                              key: `${project.getId()}-delete-schedule`,
                                              label: 'Delete Schedule'
                                          },
                                          {
                                              key: `${project.getId()}-export-schedule`,
                                              label: 'Export Schedule'
                                          },
                                          {
                                              key: `${project.getId()}-share-schedule`,
                                              label: 'Share Schedule'
                                          }],
                                      onClick: (e) => {
                                          const {key, keyPath, domEvent} = e;
                                          domEvent.stopPropagation();
                                          setSelectedKeys(keyPath);
                                          const projectId = key.split("-")[0];
                                          switch (key) {
                                              case `${projectId}-open-in-new-table`:
                                                  window.open(`http://127.0.0.1:3000/home-page/schedule/maintenance/${projectId}`, "_blank")
                                                  break;
                                              case `${projectId}-rename-schedule`:
                                                  // dispatch(setRenameScheduleId(projectId));
                                                  // dispatch(setRenameScheduleModalVisible(true));
                                                  break;
                                              case `${projectId}-add-to-favorites`:
                                                  break;
                                              case `${projectId}-save-as-a-template`:
                                                  break;
                                              case `${projectId}-delete-schedule`:
                                                  // deleteSchedule(projectId);
                                                  break;
                                              case `${projectId}-export-schedule`:
                                                  break;
                                              case `${projectId}-share-schedule`:
                                                  break;
                                              default:
                                                  break;
                                          }
                                      }
                                  }}>
                                      <div onContextMenu={() => {
                                          // setSelectedKeys([project.getId()]);
                                          // navigate(`/home-page/schedule/maintenance/${project.getId()}`);
                                      }} onClick={() => navigate(`/home-page/schedule/maintenance/${project.getId()}`)}>
                                          {truncateString(project.getProjectName(), 14)}
                                      </div>
                                  </Dropdown>,
                              })),
                          }
                      ]}/>
            </Sider>
            <Layout className={"schedule-body"}>
                <Outlet/>
            </Layout>
        </Layout>
    )
}